package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.SingerMapper;
import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerMapper singerMapper;


    @Override
    public Boolean insertSinger(Singer singer) {

        return singerMapper.insertSinger(singer)>0 ? true : false;
    }

    @Override
    public Boolean updateSinger(Singer singer) {
        return singerMapper.updateSinger(singer)>0 ? true : false;
    }

    @Override
    public Boolean deleteSinger(int id) {
        return singerMapper.deleteSinger(id)>0 ? true : false;
    }

    @Override
    public Singer findSinger(Integer id) {
        return singerMapper.findSinger(id);
    }

    @Override
    public List<Singer> findAllSinger() {
        return singerMapper.findAllSinger();
    }

    @Override
    public Singer findSingerByName(String name) {
        return singerMapper.findSingerByName(name);
    }
}
