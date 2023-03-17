package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Music;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListenHistoryMapper {

    public boolean addListenHistory(int musicId, int userId);

    public boolean deleteListenHistory(int musicId, int userId);

    public int countListenHistory(int userId);

    public List<Music> findUserAllListenHistory(int userId);

    public Music findUserListenHistory(int musicId, int userId);

    public Music getOldestListenHistory(int userId);
}
