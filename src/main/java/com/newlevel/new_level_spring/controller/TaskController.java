package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.Task;
import com.newlevel.new_level_spring.services.TaskService;

@RestController
public class TaskController {
  
  @Autowired
  TaskService service;

  @RequestMapping("/task")
  private List<Task> getTasks(){
    return service.getTasks();
  }
  
}
