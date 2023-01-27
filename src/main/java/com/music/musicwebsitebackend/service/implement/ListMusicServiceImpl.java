package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.List_MusicMapper;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.ListMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListMusicServiceImpl implements ListMusicService {

    @Autowired
    private List_MusicMapper list_musicMapper;


    @Override
    public Boolean insertListMusic(List_Music list_music) {
        return list_musicMapper.insertList_Music(list_music) > 0 ? true : false;
    }

    @Override
    public Boolean updateListMusic(List_Music list_music) {
        return list_musicMapper.updateList_Music(list_music) > 0 ? true : false;
    }

    @Override
    public Boolean deleteListMusic(int id) {
        return list_musicMapper.deleteList_Music(id) > 0 ? true : false;
    }

    @Override
    public List_Music findListMusic(Integer id) {
        return list_musicMapper.findList_Music(id);
    }

    @Override
    public List<List_Music> findAllListMusic() {
        return list_musicMapper.findAllList_Music();
    }

    @Override
    public List_Music findByNameListMusic(String name) {
        return list_musicMapper.findList_MusicByName(name);
    }
}
