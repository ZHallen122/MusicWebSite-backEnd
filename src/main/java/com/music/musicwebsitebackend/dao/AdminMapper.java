package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Admin;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    // check passWord
    public int verifyPassword(String name, String password);

    public Admin selectByAdminName(String name);
}
