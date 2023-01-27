package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.CollectionService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @PostMapping("/addCollection")
    public Result addCollection(@RequestBody Collect collect){
        Boolean checker = collectionService.insertCollection(collect);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/deleteCollection/{userId}/{musicId}")
    public Result deleteCollection(@PathVariable("userId") int userId,@PathVariable("musicId") int musicId){
        Boolean checker = collectionService.deleteCollection(userId,musicId);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/updateCollection")
    public Result updateCollection(@RequestBody Collect collect){
        Boolean checker = collectionService.updateCollection(collect);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @GetMapping("/findCollection/{findId}")
    public Result findCollection(@PathVariable("findId") int id){
        Collect collect = collectionService.findCollection(id);
        if(collect!=null){
            return Result.success("success");
        }else{
            return Result.error("error music insert");
        }
    }
}
