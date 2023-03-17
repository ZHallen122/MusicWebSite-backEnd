package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.FavoritesMapper;
import com.music.musicwebsitebackend.entity.Favorites;
import com.music.musicwebsitebackend.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public Boolean insertFavorites(Favorites favorites) {
        return favoritesMapper.insertFavorites(favorites) > 0 ? true : false;
    }

    @Override
    public Boolean updateFavorites(Favorites favorites) {
        return favoritesMapper.updateFavorites(favorites) > 0 ? true : false;
    }

    @Override
    public Boolean deleteFavorites(Integer favorites_id) {
        return favoritesMapper.deleteFavorites(favorites_id) > 0 ? true : false;
    }

    @Override
    public Favorites findFavorites(Integer favorites_id) {
        return favoritesMapper.findFavorites(favorites_id);
    }

    @Override
    public List<Favorites> findAllFavorites() {
        return favoritesMapper.findAllFavorites();
    }
}
