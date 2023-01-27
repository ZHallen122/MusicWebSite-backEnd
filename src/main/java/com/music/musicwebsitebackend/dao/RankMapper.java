package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Comment;
import com.music.musicwebsitebackend.entity.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankMapper {

    public int insertRank(Rank rank);

    public int  updateRank(Rank rank);

    public int deleteRank(int id);

    public Rank findRank(Integer id);

    public List<Rank> findAllRank();

}
