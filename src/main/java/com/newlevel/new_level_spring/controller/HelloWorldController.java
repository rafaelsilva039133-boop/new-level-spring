package com.newlevel.new_level_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.services.HelloWorldService;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

  @Autowired
  private HelloWorldService helloWorldService;

  @GetMapping
  public String helloWorld(){
    return helloWorldService.helloWorld(" Rafael");
  }
}
