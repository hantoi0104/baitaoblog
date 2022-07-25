package com.codegym.services;

import com.codegym.model.Post;
import com.codegym.repository.IPostRepository;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class PostService implements IPostService {
@Autowired
    IPostRepository iPostRepository;
    @Override
    public Page<Post> findAll(Pageable pageable) {

        return iPostRepository.findAll(pageable);
    }

    @Override
    public void save(Post post) {
        iPostRepository.save(post);

    }

    @Override
    public void delete(int id) {
        iPostRepository.deleteById(id);

    }

    @Override
    public Optional<Post> findById(int id) {
        return Optional.empty();
    }
}
