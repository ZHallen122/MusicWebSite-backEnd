package com.music.musicwebsitebackend.service.implement;

import com.google.common.collect.Lists;
import com.music.musicwebsitebackend.dao.*;
import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.recommendation.DataType.ProductData;
import com.music.musicwebsitebackend.recommendation.DataType.RelatedData;
import com.music.musicwebsitebackend.recommendation.math.CoreMath;
import com.music.musicwebsitebackend.service.RecommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommandServiceImpl implements RecommandService {

    private static final int DEFAULT_Music_LIMIT = 3;
    private static final int DEFAULT_PER_Music_RECOMMENDATION_LIMIT = 10;
    private static final int DEFAULT_TOTAL_RECOMMENDATION_LIMIT = 20;

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Autowired
    private Music_ListMapper music_listMapper;

    @Autowired
    private CollectionMapper collectMapper;

    @Autowired
    private MusicMapper musicMapper;

    @Autowired
    private List_MusicMapper list_musicMapper;


    @Override
    public List<RelatedData> getCollectData() {
        List<RelatedData> relateDTOList = Lists.newArrayList();
        List<Collect> collectList = collectMapper.findAllCollection();
        for (Collect collect : collectList) {
            RelatedData relateDTO = new RelatedData();
            relateDTO.setUserId(collect.getUser_id());
            relateDTO.setProductId(collect.getMusic_id());
            //1-10随机数模拟用户听歌次数
            relateDTO.setIndex((int)(Math.random()*10+1));
            //relateDTO.setIndex(1);
            relateDTOList.add(relateDTO);
        }
        if(CollectionUtils.isEmpty(relateDTOList)){
            System.out.println("--------------------List<RelateDTO> is Empty！");
        }
        return relateDTOList;
    }

    @Override
    public List<RelatedData> getRatingHistoryData() {
        return null;
    }

    @Override
    public List<RelatedData> getHistoryData() {
        return null;
    }

    @Override
    public List<RelatedData> getRankData() {
        return null;
    }

    @Override
    public List<ProductData> getMusicListData() {
        return null;
    }

    @Override
    public List<ProductData> getFavoriteGenresData() {
        return null;
    }

    @Override
    public List<ProductData> getMusicData() {
        List<ProductData> productDTOList = new ArrayList<>();
        List<Music> musicList = musicMapper.findAllMusic();
        for (Music music : musicList) {
            ProductData productDTO = new ProductData();
            productDTO.setProductId(music.getId());
            productDTOList.add(productDTO);
        }
        if(CollectionUtils.isEmpty(productDTOList)){
            System.out.println("----------------------List<ProductDTO>is Empty！");
        }
        return productDTOList;
    }

    @Override
    public List<Music> recommendMusics(Integer userId) {
        CoreMath coreMath = new CoreMath();
        List<RelatedData> relateDTOList = getCollectData();
        // do recommendation algorithm
        List<Integer> recommendations = coreMath.recommend(userId, relateDTOList);
        List<ProductData> productDTOList= getMusicData().stream().filter(e->recommendations.contains(e.getProductId())).collect(Collectors.toList());
        // if recommend id is empty
        if(CollectionUtils.isEmpty(productDTOList)){
            System.out.println("-----------recommend id is empty！");
            //return songMapper.allSong();
        }
        List<Music> musicList = new ArrayList<>();
        //get music id
        List<Integer> productIdList = productDTOList.stream().map(e -> e.getProductId()).collect(Collectors.toList());
        //base on music id to get music
        for (Integer productId : productIdList) {
            musicList.add(musicMapper.findMusic(productId));
        }
        return musicList;
    }

    @Override
    public List<Music_List> recommendMusicListByCollect(Integer userId) {
        // get recommend music
        List<Music> music = recommendMusics(userId);
        // if recommend is empty, then return top 50 music List
        if(CollectionUtils.isEmpty(music)){
            return music_listMapper.topFiftyMusicList();
        }
        // music and music list correspondence table
        List<List_Music> listSongLists = list_musicMapper.findAllList_Music();
        List<Integer> musicIds = music.stream().map(e -> e.getId()).collect(Collectors.toList());
        List<List_Music> listMusics = listSongLists.stream().filter(e -> musicIds.contains(e.getMusic_id())).collect(Collectors.toList());
        List<Music_List> musicLists = new ArrayList<>();
        // get music list id set
        List<Integer> musicListIds = listMusics.stream().map(e -> e.getMusic_List_id()).collect(Collectors.toList());
        // base on music id to get music list
        for (Integer songListId : musicListIds) {
            musicLists.add(music_listMapper.findMusic_List(songListId));
        }
        //if recommend is zero than fill with top 50 music list
        if(CollectionUtils.isEmpty(musicLists)){
            return music_listMapper.topFiftyMusicList();
        }
        return musicLists;
    }


}
