package com.zys.myspringboot.controller;

import com.zys.myspringboot.dto.PaginationDTO;
import com.zys.myspringboot.dto.QuestionDTO;
import com.zys.myspringboot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @Value("${github.client.id}")
    private String clientId;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "4") Integer size,
                        @RequestParam(name = "search", required = false) String search
                        ) {
        if(search == "" || search == "*") search = null;
        PaginationDTO pagination = questionService.list(search, page, size);
        model.addAttribute("pagination", pagination);
        model.addAttribute("clientId", clientId);
        model.addAttribute("search", search);
        return "index";
    }
}
