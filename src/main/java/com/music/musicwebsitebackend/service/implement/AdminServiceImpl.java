package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.AdminMapper;
import com.music.musicwebsitebackend.entity.Admin;
import com.music.musicwebsitebackend.service.AdminService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public int verifyPassword(String email, String password) {
        return adminMapper.verifyPassword(email,password);
    }

    @Override
    public Admin selectByAdminName(String email) {

        return adminMapper.selectByAdminName(email);
    }
}
