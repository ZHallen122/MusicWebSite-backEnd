package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.CollectionMapper;
import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public Boolean insertCollection(Collect collect) {
        return collectionMapper.insertCollection(collect) > 0 ? true : false;
    }

    @Override
    public Boolean updateCollection(Collect collect) {
        return collectionMapper.updateCollection(collect) > 0 ? true : false;
    }

    @Override
    public Boolean deleteCollection(Integer userId, Integer musicId) {
        return collectionMapper.deleteCollection(userId,musicId) > 0 ? true : false;
    }

    @Override
    public Collect findCollection(Integer id) {
        return collectionMapper.findCollection(id);
    }

    @Override
    public List<Collect> findAllCollection() {
        return collectionMapper.findAllCollection();
    }

    //@Override
    //public Collect findCollectionByName(String name) {
    //    return collectionMapper.findCollectionByName(name);
    //}
}
