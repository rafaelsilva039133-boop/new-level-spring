package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.model.DTOS.UserDTO;
import com.newlevel.new_level_spring.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {
  
  private final UserService service;

  @GetMapping
  public List<User> getUsers(){
    return service.getUsers();
  }

  @GetMapping("/by-id")
  public User getUserById(@RequestParam String userId){
    return service.getUserById(userId);
  }

  @PostMapping
  public void createUser(@Valid @RequestBody UserDTO userDTO){
    service.createUser(userDTO);
  }

  @PutMapping
  public void updateUser(@Valid @RequestBody UserDTO userDTO){
    service.updateUser(userDTO);
  }

  @DeleteMapping("/by-id")
  public void deleteUser(@RequestParam String userId){
    service.deleteUser(userId);
  }
}
