package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Music_List;

import java.util.List;

public interface MusicListService {

    public Boolean insertMusic_List(Music_List music_List);

    public Boolean  updateMusic_List(Music_List music_List);

    public Boolean deleteMusic_List(int id);

    public Music_List findMusic_List(Integer id);

    public List<Music_List> findAllMusic_List();

    public List<Music_List> topFiftyMusicList();

    public Music_List findByNameMusic_List(String name);
}
