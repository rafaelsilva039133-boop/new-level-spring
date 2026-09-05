package com.newlevel.new_level_spring.model.DTOS;

import lombok.Data;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
public class UserDTO {
  @NotBlank(message = "Nome é obrigatório")
  @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
  private String name;

  @NotBlank(message = "Auth0 ID é obrigatório")
  private String auth0Id;

  @NotNull(message = "Last Login At é obrigatório")
  private LocalDateTime lastLoginAt;
}
