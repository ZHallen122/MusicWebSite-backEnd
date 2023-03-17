package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Favorites;
import java.util.List;

public interface FavoritesService {

    public Boolean insertFavorites(Favorites favorites);

    public Boolean  updateFavorites(Favorites favorites);

    public Boolean deleteFavorites(Integer favorites_id);

    public Favorites findFavorites(Integer favorites_id);

    public List<Favorites> findAllFavorites();

}
