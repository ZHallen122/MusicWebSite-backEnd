package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicMapper {

    public int insertMusic(Music music);

    public int  updateMusic(Music music);

    public int deleteMusic(int id);

    public Music findMusic(Integer id);

    public List<Music> findAllMusic();

    public Music findMusicByName(String name);
}
