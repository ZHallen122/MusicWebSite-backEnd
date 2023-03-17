package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.List_MusicMapper;
import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.ListMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ListMusicServiceImpl implements ListMusicService {

    @Autowired
    private List_MusicMapper list_musicMapper;

//    private static final Random RANDOM = new Random();
//    private static final int MIN_MUSIC_ID = 1242;
//    private static final int MAX_MUSIC_ID = 1274;
//    private static final int MIN_MUSIC_LIST_ID = 2;
//    private static final int MAX_MUSIC_LIST_ID = 51;


    @Override
    public Boolean insertListMusic(List_Music list_music) {
        return list_musicMapper.insertList_Music(list_music) > 0 ? true : false;
//        for(int i=0; i<50; i++){
//            Integer type = RANDOM.nextInt(2); // Assuming type is 0 or 1
//            Integer music_id = RANDOM.nextInt(MAX_MUSIC_ID - MIN_MUSIC_ID + 1) + MIN_MUSIC_ID;
//            Integer music_list_id = RANDOM.nextInt(MAX_MUSIC_LIST_ID - MIN_MUSIC_LIST_ID + 1) + MIN_MUSIC_LIST_ID;
//            int userId = RANDOM.nextInt(5) + 1;
//
//            List_Music testcollect = new List_Music();
//            testcollect.setMusic_id(music_id);
//            testcollect.setMusic_List_id(music_list_id);
//            list_musicMapper.insertList_Music(testcollect);
//        }
       // return true;
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
