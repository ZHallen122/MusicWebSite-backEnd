package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Comment;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.CommenteService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    private CommenteService commenteService;

    @PostMapping("/addComment")
    public Result addComment(@RequestBody Comment comment){
        Boolean checker = commenteService.insertComment(comment);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/deleteComment/{CommentId}")
    public Result deleteComment(@PathVariable("CommentId") int id){
        Boolean checker = commenteService.deleteComment(id);
        if(checker){
            return Result.success("delete success");
        }else{
            return Result.error("delete fail");
        }
    }

    // 获得指定歌曲 ID 的评论列表
    // 获得指定歌单 ID 的评论列表
    // 点赞
}
