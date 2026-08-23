package com.newlevel.new_level_spring.model;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Locale.Category;

//import org.springframework.beans.factory.annotation.Autowired;

//import com.newlevel.new_level_spring.types.Difficulty;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Task {
  
  private String id;
  private String title;
  private String description;
  //@Autowired
  //private User user;
  //private String userId;
  //private LocalDate dueDate;
  //private LocalDateTime completedAt;
  //private LocalDateTime createdAt;
  //private Category category;
  //private Difficulty difficulty;
  //private LocalDateTime updatedAt;

  
}
