package com.newlevel.new_level_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Recurso não encontrado")
public class ResponsiveStatusExeption extends RuntimeException {
  public ResponsiveStatusExeption(String message) {
    super(message);
  }
}