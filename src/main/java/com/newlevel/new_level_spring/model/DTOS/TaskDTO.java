package com.newlevel.new_level_spring.model.DTOS;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskDTO {
  @NotBlank(message = "A tarefa deve ter um titulo")
  @Size(max = 100, message = "O Titulo deve ter no máximo 100 caracteres")
  private String title;
    @Size(max = 750, message = "Nome deve ter no máximo 750 caracteres")
  private String description;
}
