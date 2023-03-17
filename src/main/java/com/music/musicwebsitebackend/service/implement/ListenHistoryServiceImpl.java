package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.ListenHistoryMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.ListenHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListenHistoryServiceImpl implements ListenHistoryService {

    @Autowired
    private ListenHistoryMapper listenHistoryMapper;


    @Override
    public boolean addListenHistory(int music_id, int user_id) {
        int count = listenHistoryMapper.countListenHistory(user_id);
        boolean check = false;
        if(count>50){
            Music music = listenHistoryMapper.getOldestListenHistory(user_id);

            listenHistoryMapper.deleteListenHistory(music.getId(),user_id);
        }else{
            check = listenHistoryMapper.addListenHistory(music_id,user_id);
        }
        return check;
    }

    @Override
    public List<Music> getUserAllListenHistory(int user_id) {
        return listenHistoryMapper.findUserAllListenHistory(user_id);
    }
}
