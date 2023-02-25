package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Rank;
import com.music.musicwebsitebackend.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public int insertUser(User user);

    public int  updateUser(User user);

    public int deleteUser(int id);

    public User findUser(String email);

    public  List<User> findAllUser();

    public User findUserByName(String username);
}
