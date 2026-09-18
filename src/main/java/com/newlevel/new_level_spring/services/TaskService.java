package com.newlevel.new_level_spring.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newlevel.new_level_spring.exception.ResponsiveStatusExeption;
import com.newlevel.new_level_spring.model.Task;
import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.model.DTOS.TaskRequestDTO;
import com.newlevel.new_level_spring.model.DTOS.TaskResponseDTO;
import com.newlevel.new_level_spring.repository.TaskRepository;
import com.newlevel.new_level_spring.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.oauth2.jwt.Jwt;

@Service
@RequiredArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  @Transactional
  public TaskResponseDTO createTask(Jwt jwt, TaskRequestDTO dto) {
    User user = userRepository.findById(jwt.getSubject())
      .orElseThrow(() -> new ResponsiveStatusExeption("Usuário não encontrado"));

    Task task = new Task();
    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setUser(user);
    task.setDueDate(dto.getDueDate());
    task.setCategory(dto.getCategory());
    task.setDifficulty(dto.getDifficulty());
    task.setCreatedAt(LocalDateTime.now());
    task.setUpdatedAt(LocalDateTime.now());
    taskRepository.save(task);
    return toResponseDTO(task);
  }

  public List<TaskResponseDTO> listTasksByUser(Jwt jwt) {
    String auth0Id = jwt.getSubject();
    return taskRepository.findAllByUserId(auth0Id)
      .stream()
      .map(this::toResponseDTO)
      .collect(Collectors.toList());
  }

  public TaskResponseDTO getTaskById(Long taskId, Jwt jwt) {
    String auth0Id = jwt.getSubject();

    Task task = findTaskOwnedByUser(taskId, auth0Id);
    return toResponseDTO(task);
  }

  @Transactional
  public TaskResponseDTO updateTask(Long taskId, Jwt jwt, TaskRequestDTO dto) {
    String auth0Id = jwt.getSubject();
    Task task = findTaskOwnedByUser(taskId, auth0Id);

    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setDueDate(dto.getDueDate());
    task.setCategory(dto.getCategory());
    task.setDifficulty(dto.getDifficulty());
    task.setUpdatedAt(LocalDateTime.now());

    return toResponseDTO(taskRepository.save(task));
  }

  @Transactional
  public TaskResponseDTO completeTask(Long taskId, Jwt jwt) {
    String auth0Id = jwt.getSubject();
    
    Task task = findTaskOwnedByUser(taskId, auth0Id);
    task.setCompletedAt(LocalDateTime.now());
    task.setUpdatedAt(LocalDateTime.now());
    return toResponseDTO(taskRepository.save(task));
  }

  @Transactional
  public void deleteTask(Long taskId, Jwt jwt) {
    String auth0Id = jwt.getSubject();

    Task task = findTaskOwnedByUser(taskId, auth0Id);
    taskRepository.delete(task);
  }

  private Task findTaskOwnedByUser(Long taskId, String auth0Id) {

    Task task = taskRepository.findById(taskId)
      .orElseThrow(() -> new ResponsiveStatusExeption("Tarefa não encontrada"));

    if (!task.getUser().getAuth0Id().equals(auth0Id)) {
      throw new ResponsiveStatusExeption("Tarefa não encontrada");
    }
    return task;
  }

  public TaskResponseDTO toResponseDTO(Task task){
    return TaskResponseDTO.builder()
      .category(task.getCategory())
      .completedAt(task.getCompletedAt())
      .createdAt(task.getCreatedAt())
      .description(task.getDescription())
      .difficulty(task.getDifficulty())
      .dueDate(task.getDueDate())
      .id(task.getId())
      .title(task.getTitle())
      .build();
  }
}