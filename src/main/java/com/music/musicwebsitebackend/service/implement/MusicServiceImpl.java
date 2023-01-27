package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.MusicMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;


    @Override
    public Boolean insertMusic(Music music) {
        return musicMapper.insertMusic(music) > 0 ? true : false;
    }

    @Override
    public Boolean updateMusic(Music music) {
        return musicMapper.updateMusic(music) > 0 ? true : false;
    }

    @Override
    public Boolean deleteMusic(int id) {
        return musicMapper.deleteMusic(id) > 0 ? true : false;
    }

    @Override
    public Music findMusic(Integer id) {
        return musicMapper.findMusic(id);
    }

    @Override
    public List<Music> findAllMusic() {
        return musicMapper.findAllMusic();
    }

    @Override
    public Music findMusicByName(String name) {
        return musicMapper.findMusicByName(name);
    }
}
