package com.codegym.services;

import com.codegym.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPostService {
    Page<Post> findAll(Pageable pageable);
    void save(Post post);
    void delete(int id);
    Optional<Post> findById(int id);
}
