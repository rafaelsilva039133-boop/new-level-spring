package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.services.UserService;

@RestController
public class UserController {
  
  @Autowired
  UserService service;

  @RequestMapping("/user")
  public List<User> getUsers(){
    return service.getUsers();
  }

  //@RequestMapping("/user")
}
