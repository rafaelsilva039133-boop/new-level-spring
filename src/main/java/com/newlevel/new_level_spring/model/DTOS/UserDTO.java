package com.newlevel.new_level_spring.model.DTOS;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class UserDTO {
  @NotBlank(message = "Nome é obrigatório")
  @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
  private String name;
}
