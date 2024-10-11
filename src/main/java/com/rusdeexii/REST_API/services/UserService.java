package com.rusdeexii.REST_API.services;

import com.rusdeexii.REST_API.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findById(int id);
    void deleteById(int id);
}
