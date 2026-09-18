package com.newlevel.new_level_spring.model.DTOS;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
  @NotBlank(message = "Nome é obrigatório")
  private String name;

}
