package com.newlevel.new_level_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Locale.Category;

//import com.newlevel.new_level_spring.types.Difficulty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Builder
public class Task {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  //private LocalDate dueDate;
  //private LocalDateTime completedAt;
  //private LocalDateTime createdAt;
  //private Category category;
  //private Difficulty difficulty;
  //private LocalDateTime updatedAt;

  
}
