package com.zys.myspringboot.servingwebcontent;

import com.zys.myspringboot.mapper.UserMapper;
import com.zys.myspringboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest requeset){
        Cookie[] cookies = requeset.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")) {
                User user = userMapper.findByToken(cookie.getValue());
                if(user != null){
                    requeset.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        return "index";
    }
}
