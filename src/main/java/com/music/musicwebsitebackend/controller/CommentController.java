package com.music.musicwebsitebackend.controller;

import com.music.musicwebsitebackend.entity.Comment;
import com.music.musicwebsitebackend.entity.List_Music;
import com.music.musicwebsitebackend.service.CommenteService;
import com.music.musicwebsitebackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommenteService commenteService;

    @PostMapping("/add")
    public Result addComment(@RequestBody Comment comment){
        Boolean checker = commenteService.insertComment(comment);
        if(checker){
            return Result.success("adding success");
        }else{
            return Result.error("adding fail");
        }
    }

    @GetMapping("/delete")
    public Result deleteComment(@RequestParam("comment_id") int comment_id){
        Boolean checker = commenteService.deleteComment(comment_id);
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
