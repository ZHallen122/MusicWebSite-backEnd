package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.Music_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper {

    public int insertCollection(Collect collect);

    public int  updateCollection(Collect collect);

    public int deleteCollection(@Param("userId") Integer userId, @Param("songId") Integer songId);

    public Collect findCollection(Integer user_id, Integer collect_id);

    public List<Collect> findAllCollection();

    // Collect findCollectionByName(String name);

}
