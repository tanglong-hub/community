package com.zys.myspringboot.service;

import com.zys.myspringboot.dto.PaginationDTO;
import com.zys.myspringboot.dto.QuestionDTO;
import com.zys.myspringboot.dto.QuestionQueryDTO;
import com.zys.myspringboot.exception.CustomizeErrorCode;
import com.zys.myspringboot.exception.CustomizeException;
import com.zys.myspringboot.mapper.QuestionExtMapper;
import com.zys.myspringboot.mapper.QuestionMapper;
import com.zys.myspringboot.mapper.UserMapper;
import com.zys.myspringboot.model.Question;
import com.zys.myspringboot.model.QuestionExample;
import com.zys.myspringboot.model.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public PaginationDTO list(String search, Integer page, Integer size) {

        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        QuestionQueryDTO questionQueryDTO = new QuestionQueryDTO();
        questionQueryDTO.setSearch(search);

        Integer totalCount = questionExtMapper.countBySearch(questionQueryDTO);

        Integer totalPage = (int) Math.ceil((double)totalCount / size);
        if (page < 1) page = 1;
        if (page > totalPage) page = totalPage;

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        if (offset < 0) offset = 0;

        questionQueryDTO.setSize(size);
        questionQueryDTO.setOffset(offset);
        List<Question> questions = questionExtMapper.selectBySearch(questionQueryDTO);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Long userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userId);
        Integer totalCount = (int) questionMapper.countByExample(example);
        Integer totalPage = (int) Math.ceil((double)totalCount / size);
        if (page > totalPage) page = totalPage;
        if (page < 1) page = 1;

        paginationDTO.setPagination(totalPage, page);

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setData(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Long id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question == null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setViewCount(0);
            question.setCommentCount(0);
            question.setLikeCount(0);
            questionMapper.insertSelective(question);
        } else {
            int updated = questionMapper.updateByPrimaryKeySelective(question);
            if(updated != 1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void incView(Long id) {
        Question row = new Question();
        row.setId(id);
        row.setViewCount(1);
        questionExtMapper.incView(row);
    }

    public List<Question> selectRelated(QuestionDTO questionDTO) {
        if(questionDTO.getTag() == null || questionDTO.getTag() == ""){
            return new ArrayList<>();
        }

        String[] strs = questionDTO.getTag().split("[,，]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length - 1; i++) {
            sb.append(strs[i]).append("|");
        }
        sb.append(strs[strs.length - 1]);

        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setTag(sb.toString());
        List<Question> questionList = questionExtMapper.selectRelated(question);

        return questionList;
    }
}
