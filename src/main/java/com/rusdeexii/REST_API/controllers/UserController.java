package com.rusdeexii.REST_API.controllers;

import com.rusdeexii.REST_API.entity.User;
import com.rusdeexii.REST_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        user.setId(0);
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User  myUser = userService.findById(id);
        if (myUser == null) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        return myUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        User myUser = userService.findById(id);
        if(myUser == null) {
            throw new RuntimeException("User with id " + id + " not found");
        }
        userService.deleteById(id);
        return  "delete user Id :" + id + "  " + " Successfully";
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

}
