package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Music_List;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface List_MusicMapper {

    public int insertList_Music(List_Music list_music);

    public int  updateList_Music(List_Music list_music);

    public int deleteList_Music(int id);

    public List_Music findList_Music(Integer id);

    public List<List_Music> findAllList_Music();

    public List_Music findList_MusicByName(String name);
}
