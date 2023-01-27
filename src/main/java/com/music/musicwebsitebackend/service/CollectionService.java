package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.List_Music;

import java.util.List;

public interface CollectionService {

    public Boolean insertCollection(Collect collect);

    public Boolean  updateCollection(Collect collect);

    public Boolean deleteCollection(Integer userId, Integer musicId);

    public Collect findCollection(Integer id);

    public List<Collect> findAllCollection();
}
