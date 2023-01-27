package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Music_ListMapper {

    public int insertMusic_List(Music_List music_List);

    public int  updateMusic_List(Music_List music_List);

    public int deleteMusic_List(int id);

    public Music_List findMusic_List(Integer id);

    public List<Music_List> findAllMusic_List();

    public Music_List findByNameMusic_List(String name);
}
