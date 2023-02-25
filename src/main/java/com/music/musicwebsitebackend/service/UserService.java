package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    public boolean login(String email, String password);

    public User selectByUserName(String email);

    public boolean signUp(User user);

    public List<User> findAllUser();
}
