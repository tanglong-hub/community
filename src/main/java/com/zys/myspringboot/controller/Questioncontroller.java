package com.zys.myspringboot.controller;

import com.zys.myspringboot.dto.CommentDTO;
import com.zys.myspringboot.dto.QuestionDTO;
import com.zys.myspringboot.enums.CommentTypeEnum;
import com.zys.myspringboot.model.Question;
import com.zys.myspringboot.service.CommentService;
import com.zys.myspringboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class Questioncontroller {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        List<Question> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> commentDTOs = commentService.getListById(id, CommentTypeEnum.QUESTION);

        questionService.incView(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", commentDTOs);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
