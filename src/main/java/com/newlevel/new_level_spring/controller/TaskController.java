package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @RequestMapping("/task/{taskId}")
  private Task getTaskById(@PathVariable Long taskId){
    return service.geTaskById(taskId);
  }

  @PostMapping("/task")
  private void addTask(@RequestBody Task task){
    service.addTask(task);
  }

  @PutMapping("/task")
  private void updateTask(@RequestBody Task task){
    service.updateTask(task);
  }

  @DeleteMapping("/task/{taskId}")
  private void deleteTask(@PathVariable Long taskId){
    service.deleteTask(taskId);
  }
}
