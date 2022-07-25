package com.codegym.services;

import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserService implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public List<User> findAll() {
        return (List<User>)iUserRepository.findAll();
    }
}
