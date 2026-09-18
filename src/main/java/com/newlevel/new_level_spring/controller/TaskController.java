package com.newlevel.new_level_spring.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.DTOS.TaskRequestDTO;
import com.newlevel.new_level_spring.model.DTOS.TaskResponseDTO;
import com.newlevel.new_level_spring.services.TaskService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/task")
@RestController
public class TaskController {

  private final TaskService service;

  @GetMapping
  public List<TaskResponseDTO> getTasks(@AuthenticationPrincipal Jwt jwt) {
    return service.listTasksByUser(jwt);
  }

  @GetMapping("/{taskId}")
  public TaskResponseDTO getTaskById(@PathVariable Long taskId, @AuthenticationPrincipal Jwt jwt) {
    return service.getTaskById(taskId, jwt);
  }

  @PostMapping
  public TaskResponseDTO addTask(@Valid @RequestBody TaskRequestDTO taskDTO, @AuthenticationPrincipal Jwt jwt) {
    return service.createTask(jwt, taskDTO);
  }

  @PutMapping("/{taskId}")
  public TaskResponseDTO updateTask(@PathVariable Long taskId, @Valid @RequestBody TaskRequestDTO taskDTO, @AuthenticationPrincipal Jwt jwt) {
    return service.updateTask(taskId, jwt, taskDTO);
  }

  @PatchMapping("/{taskId}/done")
  public TaskResponseDTO completeTask(@PathVariable Long taskId, @AuthenticationPrincipal Jwt jwt) {
    return service.completeTask(taskId, jwt);
  }

  @DeleteMapping("/{taskId}")
  public void deleteTask(@PathVariable Long taskId, @AuthenticationPrincipal Jwt jwt) {
    service.deleteTask(taskId, jwt);
  }
}