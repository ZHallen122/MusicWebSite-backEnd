package com.music.musicwebsitebackend.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.utils.MusicResponse;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private AmazonS3 amazonS3;


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 文件最大10M,DataUnit提供5中类型B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // 设置总上传数据总大小10M
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

    // need to change !!!!!!!!!!!!
    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin')")
    public Result addMusic(@RequestParam("name") String name,
                           @RequestParam("introduction") String introduction,
                           @RequestParam("lyric") String lyric,
                           @RequestParam("type") String type,
                           @RequestParam("music")MultipartFile musicFile,
                           @RequestParam("pic")MultipartFile picFile) {
        // system time
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);

        Music music = new Music();
        music.setName(name);
        music.setIntroduction(introduction);
        music.setSinger_id(1);
//        music.setCreate_time(new Date());
//        music.setUpdate_time(new Date());
        music.setLyric(lyric);
        music.setTypes(type);

        boolean checker = musicService.insertMusic(music,musicFile,picFile);
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
        List<Music> musicList = musicService.findAllMusic();
        if(musicList!=null){
            List<MusicResponse> responseList = new ArrayList<>();
            for (Music music : musicList) {
                String musicUrl = amazonS3.getUrl("music-web-music", music.getUrl()).toString();
                String picUrl = amazonS3.getUrl("music-web-music", music.getPic()).toString();
                MusicResponse response = new MusicResponse(music, musicUrl, picUrl);
                responseList.add(response);
            }
            return Result.success(responseList);
        }else{
            return Result.error("error music insert");
        }
    }
}
