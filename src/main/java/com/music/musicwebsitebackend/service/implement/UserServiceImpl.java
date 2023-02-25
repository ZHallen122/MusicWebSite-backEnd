package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.UserMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.User;
import com.music.musicwebsitebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public User selectByUserName(String email) {
        return userMapper.findUserByName(email);
    }

    @Override
    public boolean signUp(User user) {
        return userMapper.insertUser(user) > 0;
    }

    @Override
    public List<User> findAllUser() { return userMapper.findAllUser();}


}
