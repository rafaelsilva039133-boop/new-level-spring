package com.newlevel.new_level_spring.model.DTOS;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
  @NotBlank(message = "Nome é obrigatório")
  private String name;

}
