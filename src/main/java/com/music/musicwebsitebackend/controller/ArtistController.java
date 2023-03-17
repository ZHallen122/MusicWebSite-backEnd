package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Artist;
import com.music.musicwebsitebackend.service.ArtistService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('admin')")
    public Result addSinger(@RequestBody Artist artist){
        Boolean checker = artistService.insertArtist(artist);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('admin')")
    public Result deleteSinger(@RequestParam("artist_id") int artist_id){
        Boolean checker = artistService.deleteArtist(artist_id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('admin')")
    public Result updateSinger(@RequestBody Artist artist){
        Boolean checker = artistService.updateArtist(artist);
        if(checker){
            return Result.success("update success");
        }else{
            return Result.error("update fail");
        }
    }

    @GetMapping("/search")
    public Result searchSinger(@RequestParam("artist_id")int artist_id){
        Artist singer = artistService.findArtist(artist_id);
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("search fail");
        }
    }

    @GetMapping("/search/all")
    @PreAuthorize("hasAuthority('admin')")
    public Result searchAllSinger(){
        List<Artist> singer = artistService.findAllArtist();
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("search fail");
        }
    }

    @GetMapping("/search/name")
    @PreAuthorize("hasAuthority('admin')")
    public Result searchSingerByName(@RequestParam("artist_name")String artist_name){
        Artist singer = artistService.findArtistByName(artist_name);
        if(singer!=null){
            return Result.success(singer);
        }else{
            return Result.error("search fail");
        }
    }

}
