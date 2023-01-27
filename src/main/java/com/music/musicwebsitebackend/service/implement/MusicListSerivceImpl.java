package com.music.musicwebsitebackend.service.implement;


import com.music.musicwebsitebackend.dao.Music_ListMapper;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicListSerivceImpl implements MusicListService {

    @Autowired
    private Music_ListMapper music_listMapper;

    @Override
    public Boolean insertMusic_List(Music_List music_List) {
        return music_listMapper.insertMusic_List(music_List) > 0 ? true : false;
    }

    @Override
    public Boolean updateMusic_List(Music_List music_List) {
        return music_listMapper.updateMusic_List(music_List) > 0 ? true : false;
    }

    @Override
    public Boolean deleteMusic_List(int id) {
        return music_listMapper.deleteMusic_List(id) > 0 ? true : false;
    }

    @Override
    public Music_List findMusic_List(Integer id) {
        return music_listMapper.findMusic_List(id);
    }

    @Override
    public List<Music_List> findAllMusic_List() {
        return music_listMapper.findAllMusic_List();
    }

    @Override
    public Music_List findByNameMusic_List(String name) {
        return music_listMapper.findByNameMusic_List(name);
    }
}
