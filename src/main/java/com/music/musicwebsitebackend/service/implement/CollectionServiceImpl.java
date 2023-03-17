package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.CollectionMapper;
import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CollectionServiceImpl implements CollectionService {
//    private static final Random RANDOM = new Random();
//    private static final int MIN_MUSIC_ID = 1242;
//    private static final int MAX_MUSIC_ID = 1274;
//    private static final int MIN_MUSIC_LIST_ID = 1;
//    private static final int MAX_MUSIC_LIST_ID = 50;
//    private static final List<String> TYPES = Arrays.asList("Rock", "Pop", "Hip-Hop", "Jazz", "Classical");
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public Boolean insertCollection(Collect collect) {
        return collectionMapper.insertCollection(collect) > 0 ? true : false;
        /**test*/
//        for(int i=0; i<50; i++){
//            Integer type = RANDOM.nextInt(2); // Assuming type is 0 or 1
//            Integer music_id = RANDOM.nextInt(MAX_MUSIC_ID - MIN_MUSIC_ID + 1) + MIN_MUSIC_ID;
//            Integer music_list_id = RANDOM.nextInt(MAX_MUSIC_LIST_ID - MIN_MUSIC_LIST_ID + 1) + MIN_MUSIC_LIST_ID;
//            int userId = RANDOM.nextInt(5) + 1;
//
//            Collect testcollect = new Collect();
//            testcollect.setUser_id(userId);
//            testcollect.setType(type);
//            testcollect.setMusic_id(music_id);
//            testcollect.setMusic_list_id(music_list_id);
//            collectionMapper.insertCollection(testcollect);
//        }
//        return true;
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
    public Collect findCollection(Integer user_id, Integer collect_id) {
        return collectionMapper.findCollection(user_id, collect_id);
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
