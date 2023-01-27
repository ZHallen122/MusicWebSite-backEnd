package com.music.musicwebsitebackend.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.music.musicwebsitebackend.service.AdminService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/admin/login/status",method = RequestMethod.POST)
    public int LoginStatus(HttpServletRequest request, HttpSession session){

        return adminService.verifyPassword(request,session);
    }

}
