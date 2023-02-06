package com.music.musicwebsitebackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.music.musicwebsitebackend.Security.JwtTokenUtil;
import com.music.musicwebsitebackend.entity.Admin;
import com.music.musicwebsitebackend.entity.User;
import com.music.musicwebsitebackend.service.AdminService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public Result LoginStatus(@RequestParam("email") String email, @RequestParam("password")String password) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        Admin admin = adminService.selectByAdminName(email);
        //login fail
        if(admin == null || !admin.getPassword().equals(password)){
            return Result.error("Login fail");
        }else{
            Map<String, Object> map = new HashMap<>();
            map.put("role",admin.getRole());
            String id = " "+admin.getId();
            String token = jwtTokenUtil.generateToken(id,admin.getName(),map);
            return Result.success(token,"success");
        }
    }

}
