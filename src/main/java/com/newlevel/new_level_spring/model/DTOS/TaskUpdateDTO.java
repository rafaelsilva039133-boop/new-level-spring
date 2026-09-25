package com.newlevel.new_level_spring.model.DTOS;

import java.time.LocalDate;

import com.newlevel.new_level_spring.types.Category;
import com.newlevel.new_level_spring.types.Difficulty;

import lombok.Data;

@Data
public class TaskUpdateDTO {
  private String title;
  private String description;
  private LocalDate dueDate;
  private Category category;
  private Difficulty difficulty;
}
