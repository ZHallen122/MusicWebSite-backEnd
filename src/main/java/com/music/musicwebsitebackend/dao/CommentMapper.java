package com.music.musicwebsitebackend.dao;

import com.music.musicwebsitebackend.entity.Collect;
import com.music.musicwebsitebackend.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    public int insertComment(Comment comment);

    public int  updateComment(Comment comment);

    public int deleteComment(int id);

    public Comment findComment(Integer id);

    public List<Comment> findAllComment();

}
