package com.zys.myspringboot.servingwebcontent;

import com.alibaba.fastjson.JSON;
import com.zys.myspringboot.dto.AccessTokenDTO;
import com.zys.myspringboot.dto.GithubUser;
import com.zys.myspringboot.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);

        System.out.println("code = " + code);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println("accessToken: " + accessToken);
        GithubUser user = githubProvider.getuser(accessToken);
        System.out.println("name=" + user.getName());
        System.out.println("id=" + user.getId());
        System.out.println("bio=" + user.getBio());
        System.out.println("node_id=" + user.getNode_id());
        System.out.println("all user's message" + JSON.toJSONString(user));
        return "index";
    }
}
