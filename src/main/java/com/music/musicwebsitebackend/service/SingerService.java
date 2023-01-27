package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.utils.Result;

import java.util.List;

public interface SingerService {

    public Boolean insertSinger(Singer singer);

    public Boolean  updateSinger(Singer singer);

    public Boolean deleteSinger(int id);

    public Singer findSinger(Integer id);

    public List<Singer> findAllSinger();

    public Singer findSingerByName(String name);
}
