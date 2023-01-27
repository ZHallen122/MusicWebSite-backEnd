package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.service.ListMusicService;
import com.music.musicwebsitebackend.service.SingerService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/List_Music")
public class List_MusicController {
    @Autowired
    private ListMusicService listMusicService;

    @PostMapping("/add")
    public Result addList_Music(@RequestBody List_Music list_music){
        Boolean checker = listMusicService.insertListMusic(list_music);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/delete/{ListMusicId}")
    public Result deletList_Music(@PathVariable("ListMusicId") int id){
        Boolean checker = listMusicService.deleteListMusic(id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/update")
    public Result updateList_Music(@RequestBody List_Music list_music){
        Boolean checker = listMusicService.updateListMusic(list_music);
        if(checker){
            return Result.success("update success");
        }else{
            return Result.error("update fail");
        }
    }

    @PostMapping("/searchList_Music/{ListMusicId}")
    public Result searchList_Music(@PathVariable("ListMusicId")int id){
        List_Music list_music = listMusicService.findListMusic(id);
        if(list_music!=null){
            return Result.success(list_music);
        }else{
            return Result.error("update fail");
        }
    }

}
