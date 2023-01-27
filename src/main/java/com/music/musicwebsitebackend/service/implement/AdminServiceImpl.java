package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.AdminMapper;
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
    public int verifyPassword(HttpServletRequest request, HttpSession session) {
        Result r = new Result();

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int result = adminMapper.verifyPassword(name,password);
        if(result>0){
            return result;//Result.success("Login success !!!!");
        }else{
            return result;//Result.error("Login fail !!!");
        }
    }
}
