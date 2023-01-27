package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Music_List;

import java.util.List;

public interface ListMusicService {

    public Boolean insertListMusic(List_Music list_music);

    public Boolean  updateListMusic(List_Music list_music);

    public Boolean deleteListMusic(int id);

    public List_Music findListMusic(Integer id);

    public List<List_Music> findAllListMusic();

    public List_Music findByNameListMusic(String name);
}
