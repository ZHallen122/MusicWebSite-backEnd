package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Singer;

import java.util.List;

public interface MusicService {
    public Boolean insertMusic(Music music);

    public Boolean  updateMusic(Music music);

    public Boolean deleteMusic(int id);

    public Music findMusic(Integer id);

    public List<Music> findAllMusic();

    public Music findMusicByName(String name);
}
