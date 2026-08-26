package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.model.DTOS.UserDTO;
import com.newlevel.new_level_spring.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
  
  @Autowired
  UserService service;

  @GetMapping("/user")
  public List<User> getUsers(){
    return service.getUsers();
  }

  @GetMapping("/user/{userId}")
  private User getUserById(@PathVariable Long userId){
    return service.getUserById(userId);
  }

  @PostMapping("/user")
  private void addUser(@Valid @RequestBody UserDTO userDTO){
    service.addUser(userDTO);
  }

  @PutMapping("/user/{userId}")
  private void updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Long userId){
    service.updateUser(userDTO, userId);
  }

  @DeleteMapping("/user/{userId}")
  private void deleteUser(@PathVariable Long userId){
    service.deleteUser(userId);
  }
}
