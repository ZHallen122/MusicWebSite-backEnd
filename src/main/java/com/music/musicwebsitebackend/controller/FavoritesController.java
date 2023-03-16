package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Favorites;
import com.music.musicwebsitebackend.service.FavoritesService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping("/add")
    public Result addFavorites(@RequestBody Favorites favorites){
        Boolean checker = favoritesService.insertFavorites(favorites);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @PostMapping("/delete")
    public Result deleteFavorites(@RequestParam("user_id") int user_id){
        Boolean checker = favoritesService.deleteFavorites(user_id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/search")
    public Result FindFavorites(@RequestParam("favorites_id") int favorites_id){
        Favorites checker = favoritesService.findFavorites(favorites_id);
        if(checker!=null){
            return Result.success("find success");
        }else{
            return Result.error("find fail");
        }
    }
}
