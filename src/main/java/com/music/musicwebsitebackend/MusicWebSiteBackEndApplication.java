package com.music.musicwebsitebackend;

import com.music.musicwebsitebackend.Security.JwtTokenUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.music.musicwebsitebackend.dao")
public class MusicWebSiteBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicWebSiteBackEndApplication.class, args);
    }

//    @Bean
//    public JwtTokenUtil jwtTokenUtil(){
//        return new JwtTokenUtil();
//    }
}
