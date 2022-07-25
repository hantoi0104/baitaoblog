package com.codegym.services;

import com.codegym.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
