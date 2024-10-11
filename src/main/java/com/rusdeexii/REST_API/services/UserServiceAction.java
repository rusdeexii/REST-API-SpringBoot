package com.rusdeexii.REST_API.services;

import com.rusdeexii.REST_API.entity.User;
import com.rusdeexii.REST_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceAction implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceAction(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User data = null;
        if (result.isPresent()) {
            return data = result.get();
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}