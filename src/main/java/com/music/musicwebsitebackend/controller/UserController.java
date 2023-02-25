package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.Security.JwtTokenUtil;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.entity.User;
import com.music.musicwebsitebackend.service.UserService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public Result userLogin(@RequestParam("email") String email, @RequestParam("password")String password) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        User user = userService.selectByUserName(email);
        //login fail
        if(user == null || !user.getPassword().equals(password)){
            return Result.error("Login fail");
        }else{
            Map<String, Object> map = new HashMap<>();
            map.put("role",user.getRole());
            String token = jwtTokenUtil.generateToken(user.getEmail(),user.getUserName(),map);
            return Result.success(token,"success");
        }
    }

    @PostMapping("/signup")
    public Result signUp(@RequestBody User user){

        Boolean check = userService.signUp(user);
        if(check){
            return Result.success("sign up success");
        }else {
            return Result.error("sign up fail");
        }
    }

    @GetMapping("/findAllUser")
    public Result findAllUser(){
        List<User> user = userService.findAllUser();
        if(user!=null){
            return Result.success(user);
        }else{
            return Result.error("error user finding");
        }
    }

    @PostMapping("/chekValidToken")
    @PreAuthorize("hasAuthority('user')")
    public Result chekValidToken(){
        return Result.success("success token");
    }
}
