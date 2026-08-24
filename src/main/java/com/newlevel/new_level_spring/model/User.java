package com.newlevel.new_level_spring.model;

//import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class User {
  private String id;
  //private String clerkId;
  private String name;
  //private String email;
  private int level;
  private int currentXp;
  //private LocalDateTime createdAt;

}
