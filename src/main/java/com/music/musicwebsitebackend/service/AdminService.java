package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface AdminService {

    public int verifyPassword(HttpServletRequest request, HttpSession session);
}
