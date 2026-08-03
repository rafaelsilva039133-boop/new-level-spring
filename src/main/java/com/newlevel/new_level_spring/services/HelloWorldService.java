package com.newlevel.new_level_spring.services;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
  public String helloWorld(String name){
    return "Hello world" + name;
  }
}
