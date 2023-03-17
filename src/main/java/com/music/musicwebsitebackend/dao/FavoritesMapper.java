package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Comment;
import com.music.musicwebsitebackend.entity.Favorites;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesMapper {

    public int insertFavorites(Favorites favorites);

    public int  updateFavorites(Favorites favorites);

    public int deleteFavorites(Integer favorites_id);

    public Favorites findFavorites(Integer favorites_id);

    public List<Favorites> findAllFavorites();

}
