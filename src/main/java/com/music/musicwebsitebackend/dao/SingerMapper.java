package com.music.musicwebsitebackend.dao;


import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {

    public int insertSinger(Singer singer);

    public int  updateSinger(Singer singer);

    public int deleteSinger(int id);

    public Singer findSinger(Integer id);

    public List<Singer> findAllSinger();

    public Singer findSingerByName(String name);
}
