package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Rank;

import java.util.List;

public interface RankService {

    public Boolean insertRank(Rank rank);

    public Boolean  updateRank(Rank rank);

    public Boolean deleteRank(int id);

    public Rank findRank(Integer id);

    public List<Rank> findAllRank();

}
