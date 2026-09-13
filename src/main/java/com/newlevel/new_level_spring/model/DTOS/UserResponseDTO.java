package com.newlevel.new_level_spring.model.DTOS;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDTO {

    private String auth0Id;
    private String name;
    private int level;
    private int currentXp;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}