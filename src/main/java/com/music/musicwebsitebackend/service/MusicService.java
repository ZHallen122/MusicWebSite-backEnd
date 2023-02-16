package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicService {
    public boolean insertMusic(Music music, MultipartFile musicFile, MultipartFile picFile);

    public Boolean  updateMusic(Music music);

    public Boolean deleteMusic(int id);

    public Music findMusic(Integer id);

    public List<Music> findAllMusic();

    public Music findMusicByName(String name);
}
