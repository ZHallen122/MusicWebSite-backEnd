package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.recommendation.DataType.ProductData;
import com.music.musicwebsitebackend.recommendation.DataType.RelatedData;

import java.util.List;

public interface RecommandService {

    List<RelatedData> getCollectData();

    List<RelatedData> getRatingHistoryData();

    List<RelatedData> getHistoryData();

    List<RelatedData> getRankData();

    List<ProductData> getMusicListData();

    List<ProductData> getFavoriteGenresData();

    List<ProductData> getMusicData();

    List<Music> recommendMusics(Integer userId);

    List<Music_List> recommendMusicListByCollect(Integer userId);

}
