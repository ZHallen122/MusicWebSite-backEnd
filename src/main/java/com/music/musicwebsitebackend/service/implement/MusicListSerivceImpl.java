package com.music.musicwebsitebackend.service.implement;


import com.music.musicwebsitebackend.dao.Music_ListMapper;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.service.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Service
public class MusicListSerivceImpl implements MusicListService {

    @Autowired
    private Music_ListMapper music_listMapper;

//    private static final Random RANDOM = new Random();
//    private static final List<String> TITLES = Arrays.asList("Title1", "Title2", "Title3", "Title4", "Title5");
//    private static final List<String> PICS = Arrays.asList("pic1.jpg", "pic2.jpg", "pic3.jpg", "pic4.jpg", "pic5.jpg");
//    private static final List<String> INTRODUCTIONS = Arrays.asList("Intro1", "Intro2", "Intro3", "Intro4", "Intro5");
//    private static final List<String> STYLES = Arrays.asList("Style1", "Style2", "Style3", "Style4", "Style5");
//    private static final List<String> TYPES = Arrays.asList("Type1", "Type2", "Type3", "Type4", "Type5");
    @Override
    public Boolean insertMusic_List(Music_List music_List) {
           return music_listMapper.insertMusic_List(music_List) > 0 ? true : false;
        /** test */
//        for(int i=0; i<24; i++){
//            String title = TITLES.get(RANDOM.nextInt(TITLES.size()));
//            String pic = PICS.get(RANDOM.nextInt(PICS.size()));
//            String introduction = INTRODUCTIONS.get(RANDOM.nextInt(INTRODUCTIONS.size()));
//            String style = STYLES.get(RANDOM.nextInt(STYLES.size()));
//            String type = TYPES.get(RANDOM.nextInt(TYPES.size()));
//
//            Music_List music = new Music_List();
//            music.setTitle(title);
//            music.setPic(pic);
//            music.setIntroduction(introduction);
//            music.setStyle(style);
//            music.setType(type);
//
//            music_listMapper.insertMusic_List(music);
//        }
//        return true;
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
    public List<Music_List> topFiftyMusicList() {
        return music_listMapper.topFiftyMusicList();
    }

    @Override
    public Music_List findByNameMusic_List(String name) {
        return music_listMapper.findByNameMusic_List(name);
    }
}
