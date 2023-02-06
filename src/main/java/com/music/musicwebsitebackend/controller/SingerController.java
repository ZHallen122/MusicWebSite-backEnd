package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Singer;
import com.music.musicwebsitebackend.service.SingerService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService singerService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin')")
    public Result addSinger(@RequestBody Singer singer){
        Boolean checker = singerService.insertSinger(singer);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/delete/{SingerId}")
    @PreAuthorize("hasAuthority('admin')")
    public Result deletSinger(@PathVariable("SingerId") int id){
        Boolean checker = singerService.deleteSinger(id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin')")
    public Result updateSinger(@RequestBody Singer singer){
        Boolean checker = singerService.updateSinger(singer);
        if(checker){
            return Result.success("update success");
        }else{
            return Result.error("update fail");
        }
    }

    @GetMapping("/search/{Singerid}")
    public Result searchSinger(@PathVariable("Singerid")int id){
        Singer singer = singerService.findSinger(id);
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("update fail");
        }
    }

    @GetMapping("/searchAll")
    public Result searchAllSinger(){
        List<Singer> singer = singerService.findAllSinger();
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("update fail");
        }
    }

    @GetMapping("/searchSingerByName/{SingerName}")
    public Result searchSingerByName(@PathVariable("SingerName")String name){
        Singer singer = singerService.findSingerByName(name);
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("update fail");
        }
    }

}
