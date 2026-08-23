package com.newlevel.new_level_spring.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.Task;

@Service
public class TaskService {

  private List<Task> tasksList = Arrays.asList(new Task("101", "Task 1", "Passear com cachorro"), new Task("102", "Task 2", "Passear com gato"));

  public List<Task> getTasks(){
    return tasksList;
  }

  public Task geTaskById(String taskId){
    return tasksList.stream().filter(t -> t.getId().equals(taskId)).findFirst().get();
  }
}
