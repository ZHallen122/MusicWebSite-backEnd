package com.music.musicwebsitebackend.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MainController {
    @GetMapping("/token")
    public Token getToken(JwtAuthenticationToken jwtToken) {
        return new Token(
                jwtToken.getToken(),
                jwtToken.getAuthorities()
        );
    }    public record Token(Jwt token, Collection<GrantedAuthority> authorities){}

    @GetMapping("/read")
    public String read() {
        return "Welcome to the internet, i'll be your guide";
    }

    @GetMapping("/write")
    public String write() {
        return "I know kung fu!";
    }

    @GetMapping("/user")
    public String user() {
        return "You can't judge me, i am justice itself";
    }

    @GetMapping("/admin")
    public String admin() {
        return "All your base are belong to us";
    }
}
