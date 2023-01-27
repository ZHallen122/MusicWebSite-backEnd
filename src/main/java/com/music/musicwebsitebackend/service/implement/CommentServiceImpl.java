package com.music.musicwebsitebackend.service.implement;

import com.music.musicwebsitebackend.dao.CommentMapper;
import com.music.musicwebsitebackend.entity.Comment;
import com.music.musicwebsitebackend.service.CommenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommenteService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Boolean insertComment(Comment comment) {
        return commentMapper.insertComment(comment) > 0 ? true : false;
    }

    @Override
    public Boolean updateComment(Comment comment) {
        return commentMapper.updateComment(comment) > 0 ? true : false;
    }

    @Override
    public Boolean deleteComment(int id) {
        return commentMapper.deleteComment(id) > 0 ? true : false;
    }

    @Override
    public Comment findComment(Integer id) {
        return commentMapper.findComment(id);
    }

    @Override
    public List<Comment> findAllComment() {
        return commentMapper.findAllComment();
    }
}
