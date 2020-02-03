package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.AccessTokenDTO;
import com.duoduo.hashming.artisan.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider giteeProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("947ed878b822a3a91774");
        accessTokenDTO.setClient_secret("565b00320c05489a19e66577c9dd4b4778428735");
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        giteeProvider.getAccessToken(accessTokenDTO);
        return "index";

    }

}
