package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Admin;
import com.music.musicwebsitebackend.entity.User;
import com.music.musicwebsitebackend.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface AdminService {

    public int verifyPassword(String email, String password);

    public Admin selectByAdminName(String email);

}
