package com.newlevel.new_level_spring.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlevel.new_level_spring.types.Difficulty;

@Component
public class Task {
  
  private int id;
  private String title;
  private String description;
  @Autowired
  private User user;
  private String userId;
  private LocalDate dueDate;
  private LocalDateTime completedAt;
  private LocalDateTime createdAt;
  private Category category;
  private Difficulty difficulty;
  private LocalDateTime updatedAt;


  public Task(int id, String title, String description, User user){
    this.user = user;
    this.userId = user.getId();
  }
  
}
