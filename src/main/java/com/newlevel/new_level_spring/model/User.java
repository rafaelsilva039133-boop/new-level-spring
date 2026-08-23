package com.newlevel.new_level_spring.model;

import org.springframework.stereotype.Component;

//import java.time.LocalDateTime;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Component
public class User {
  private String id;
  //private String clerkId;
  private String name;
  //private String email;
  private int level;
  private int currentXp;
  //private LocalDateTime createdAt;

  public int getCurrentXp() {
    return currentXp;
  }

  public String getId() {
    return id;
  }

  public int getLevel() {
    return level;
  }

  public String getName() {
    return name;
  }

  public void setCurrentXp(int currentXp) {
    this.currentXp = currentXp;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}
