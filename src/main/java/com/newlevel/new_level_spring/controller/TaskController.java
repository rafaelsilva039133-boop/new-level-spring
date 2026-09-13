package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.newlevel.new_level_spring.model.Task;
import com.newlevel.new_level_spring.model.DTOS.TaskDTO;
import com.newlevel.new_level_spring.services.TaskService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/task")
@RestController
public class TaskController {
  
  private final TaskService service;

  @GetMapping
  private List<Task> getTasks(){
    return service.getTasks();
  }

  @GetMapping("/{taskId}")
  private Task getTaskById(@PathVariable Long taskId){
    return service.getTaskById(taskId);
  }

  @PostMapping
  private void addTask(@Valid @RequestBody TaskDTO taskDTO){
    service.addTask(taskDTO);
  }

  @PutMapping("/{taskId}")
  private void updateTask(@Valid @RequestBody TaskDTO taskDTO, @PathVariable Long taskId){
    service.updateTask(taskDTO, taskId);
  }

  @DeleteMapping("/{taskId}")
  private void deleteTask(@PathVariable Long taskId){
    service.deleteTask(taskId);
  }
}
