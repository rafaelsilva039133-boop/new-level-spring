package com.newlevel.new_level_spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.Task;
import com.newlevel.new_level_spring.model.DTOS.TaskDTO;
import com.newlevel.new_level_spring.repository.TaskRepository;
import com.newlevel.new_level_spring.tools.ResponsiveStatusExeption;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public List<Task> getTasks(){
    return taskRepository.findAll();
  }

  public Task getTaskById(Long taskId){
    return taskRepository.findById(taskId).orElseThrow(() -> new ResponsiveStatusExeption("Task not found"));
  }

  public Task addTask(TaskDTO taskDTO){
    Task task = Task.builder()
      .title(taskDTO.getTitle())
      .description(taskDTO.getDescription())
      .build();

    return taskRepository.save(task);
  }

  public void updateTask(TaskDTO taskDTO, Long id){
    getTaskById(id);
    Task task = Task.builder()
      .title(taskDTO.getTitle())
      .description(taskDTO.getDescription())
      .id(id)
      .build(); 
    taskRepository.save(task);
  }

  public void deleteTask(Long taskId){
    taskRepository.delete(getTaskById(taskId));
  }
}
