package com.music.musicwebsitebackend.controller;


import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.service.MusicListService;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicList")
public class MusicListController {
    @Autowired
    private MusicListService musicListService;

    @PostMapping("/add")
    public Result addMusicList(@RequestBody Music_List music_list){
        Boolean checker = musicListService.insertMusic_List(music_list);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/delete/{MusicListId}")
    public Result deleteMusicList(@PathVariable("MusicListId") int id){
        Boolean checker = musicListService.deleteMusic_List(id);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music delete");
        }
    }

    @PostMapping("/update")
    public Result upDateMusicList(@RequestBody Music_List music_list){
        Boolean checker = musicListService.updateMusic_List(music_list);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/findMusicList/{findId}")
    public Result findMusicList(@PathVariable("findId") int id){
        Music_List music_list = musicListService.findMusic_List(id);
        if(music_list!=null){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/findAllMusicList")
    public Result findAllMusicList(){
        List<Music_List> music_list = musicListService.findAllMusic_List();
        if(music_list!=null){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }
}
