package com.codegym.services;

import com.codegym.model.Comment;
import com.codegym.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CommentService implements ICommentService{
    @Override
    public List<Comment> findByPost(Post post) {
        return null;
    }

    @Override
    public void save(Comment comment) {

    }

    @Override
    public void delete(Long id) {

    }
}
