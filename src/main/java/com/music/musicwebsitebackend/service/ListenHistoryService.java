package com.music.musicwebsitebackend.service;


import com.music.musicwebsitebackend.entity.Music;

import java.util.List;

public interface ListenHistoryService {

    public boolean addListenHistory(int music_id, int user_id);

    public List<Music> getUserAllListenHistory(int user_id);

}
