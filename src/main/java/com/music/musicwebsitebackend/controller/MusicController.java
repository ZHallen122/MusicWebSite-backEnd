package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }
    @Autowired
    private MusicService musicService;

    // need to change !!!!!!!!!!!!
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin')")
    public Result addMusic(@RequestBody Music music, @RequestParam("file")MultipartFile multipartFile){
        Boolean checker = musicService.insertMusic(music);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/delete/{musicId}")
    @PreAuthorize("hasAuthority('admin')")
    public Result deleteMusic(@PathVariable("musicId") int id){
        Boolean checker = musicService.deleteMusic(id);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music delete");
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin')")
    public Result upDateMusic(@RequestBody Music music){
        Boolean checker = musicService.updateMusic(music);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/findMusic/{findId}")
    public Result findMusic(@PathVariable("findId") int id){
        Music music = musicService.findMusic(id);
        if(music!=null){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }

    @GetMapping("/findAllMusic")
    @PreAuthorize("hasAuthority('admin')")
    public Result findAllMusic(){
        List<Music> music = musicService.findAllMusic();
        if(music!=null){
            return Result.success(music);
        }else{
            return Result.error("error music insert");
        }
    }
}
