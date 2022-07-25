package com.codegym.services;
import com.codegym.model.Comment;
import com.codegym.model.Post;

import java.util.List;

public interface ICommentService {
    List<Comment> findByPost(Post post);
    void save(Comment comment);
    void delete(Long id);
}
