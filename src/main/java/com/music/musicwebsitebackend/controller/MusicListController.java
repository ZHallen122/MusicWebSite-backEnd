package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.entity.Music_List;
import com.music.musicwebsitebackend.service.MusicListService;
import com.music.musicwebsitebackend.service.RecommandService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicList")
public class MusicListController {
    @Autowired
    private MusicListService musicListService;

    @Autowired
    private RecommandService recommandService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('admin')")
    public Result addMusicList(@RequestBody Music_List music_list){
        Boolean checker = musicListService.insertMusic_List(music_list);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('admin')")
    public Result deleteMusicList(@RequestParam("music_list_id") int music_list_id){
        Boolean checker = musicListService.deleteMusic_List(music_list_id);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music delete");
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('admin')")
    public Result upDateMusicList(@RequestBody Music_List music_list){
        Boolean checker = musicListService.updateMusic_List(music_list);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music update");
        }
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result findMusicList(@RequestParam("music_list_id") int music_list_id){
        Music_List music_list = musicListService.findMusic_List(music_list_id);
        if(music_list!=null){
            return Result.success(music_list);
        }else{
            return Result.error("error find music");
        }
    }

    @GetMapping("/search/all")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result findAllMusicList(){
        List<Music_List> music_list = musicListService.findAllMusic_List();
        if(music_list!=null){
            return Result.success(music_list);
        }else{
            return Result.error("error find all musicList");
        }
    }

    @GetMapping("/topFifty/ml")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result topFiftyMusicList(){
        List<Music_List> music_list = musicListService.topFiftyMusicList();
        if(music_list!=null){
            return Result.success(music_list);
        }else{
            return Result.error("error top music");
        }
    }


    @GetMapping("/recommend/ml")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result recommendMusicListByCollect(@RequestParam("user_id") int user_id){
        List<Music_List> recommendMusicList = recommandService.recommendMusicListByCollect(user_id);
        if(recommendMusicList!=null){
            return Result.success(recommendMusicList);
        }else{
            return Result.error("error recommend Fail");
        }
    }
}
