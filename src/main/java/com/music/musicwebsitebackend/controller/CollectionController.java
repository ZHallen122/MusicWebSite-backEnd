package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.Music;
import com.music.musicwebsitebackend.service.CollectionService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result addCollection(@RequestBody Collect collect){
        Boolean checker = collectionService.insertCollection(collect);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result deleteCollection(@RequestParam("user_id") int user_id,@RequestParam("music_id") int music_id){
        Boolean checker = collectionService.deleteCollection(user_id,music_id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result updateCollection(@RequestBody Collect collect){
        Boolean checker = collectionService.updateCollection(collect);
        if(checker){
            return Result.success("update success");
        }else{
            return Result.error("update fail");
        }
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyAuthority('admin', 'user')")
    public Result findCollection(@RequestParam("user_id") int user_id,
                                 @RequestParam("collect_id") int collect_id){
        Collect collect = collectionService.findCollection(user_id,collect_id);
        if(collect!=null){
            return Result.success(collect,"find music success");
        }else{
            return Result.error("error find music");
        }
    }
}
