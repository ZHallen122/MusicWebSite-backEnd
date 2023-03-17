package com.music.musicwebsitebackend.service;

import com.music.musicwebsitebackend.entity.Comment;

import java.util.List;

public interface CommenteService {

    public Boolean insertComment(Comment comment);

    public Boolean  updateComment(Comment comment);

    public Boolean deleteComment(int id);

    public Comment findComment(Integer id);

    public List<Comment> findAllComment();
}
