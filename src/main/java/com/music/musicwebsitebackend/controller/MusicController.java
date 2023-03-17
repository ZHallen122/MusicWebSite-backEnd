package com.music.musicwebsitebackend.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.MusicService;
import com.music.musicwebsitebackend.service.RecommandService;
import com.music.musicwebsitebackend.utils.MusicResponse;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private RecommandService recommandService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // maxfile size 20MB, support B,KB,MB,GB,TB
        factory.setMaxFileSize(DataSize.of(20, DataUnit.MEGABYTES));
        // set to 10MB
        factory.setMaxRequestSize(DataSize.of(20, DataUnit.MEGABYTES));
        return factory.createMultipartConfig();
    }

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

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('admin')")
    public Result deleteMusic(@RequestParam("music_id") int music_id){
        Boolean checker = musicService.deleteMusic(music_id);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music delete");
        }

    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin')")
    public Result updateMusic(@RequestBody Music music){
        Boolean checker = musicService.updateMusic(music);
        if(checker){
            return Result.success("success");
        }else{
            return Result.error("error music update");
        }
    }

    @GetMapping("/search")
    public Result findMusic(@RequestParam("music_id") int music_id){
        Music music = musicService.findMusic(music_id);
        if(music!=null){
            return Result.success(music,"success");
        }else{
            return Result.error("error music find");
        }
    }

    @GetMapping("/topFifty")
    public Result topFiftyMusic(){

        List<Music> musics = musicService.topFiftyMusic();
        if(musics != null){
            return Result.success(musics,"success");
        }else{
            return Result.error("error top music not found");
        }
    }

    @GetMapping("/search/all")
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
            return Result.error("error music findAll");
        }
    }

    @GetMapping("/recommend/m")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result recommendMusicListByCollect(@RequestParam("user_id") int user_id){
        //generate key
        List<Music> recommendMusicList_Test = null;
        String key = "recommend/m " + user_id;
        System.out.println("Generated key: " + key);
        //get the cache
        recommendMusicList_Test = (List<Music>) redisTemplate.opsForValue().get(key);
        //if have return
        if(recommendMusicList_Test != null){
            return Result.success(recommendMusicList_Test);
        }

        List<Music> recommendMusicList = recommandService.recommendMusics(user_id);
        if(recommendMusicList!=null){
            redisTemplate.opsForValue().set(key,recommendMusicList,60, TimeUnit.MINUTES);
            return Result.success(recommendMusicList);
        }else{
            return Result.error("error recommend Fail");
        }
    }
}
