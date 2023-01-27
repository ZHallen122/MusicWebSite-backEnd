package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Rank;
import com.music.musicwebsitebackend.service.RankService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @RequestMapping(value = "/addRank", method = RequestMethod.POST)
    public Result addRank(@RequestBody Rank rank){
        Boolean checker = rankService.insertRank(rank);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Result rankOfSongListId(@RequestParam int id){
        Rank checker = rankService.findRank(id);
        if(checker!=null){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }
}
