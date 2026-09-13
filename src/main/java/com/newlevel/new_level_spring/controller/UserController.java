package com.newlevel.new_level_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlevel.new_level_spring.model.DTOS.UserDTO;
import com.newlevel.new_level_spring.model.DTOS.UserResponseDTO;
import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserController {

  private final UserService service;

  @GetMapping("/me")
  public ResponseEntity<UserResponseDTO> me(Jwt jwt) {
    return ResponseEntity.ok(service.getCurrentUser(jwt));
  }

  @PostMapping
  public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserDTO userDTO, Jwt jwt) {
    return ResponseEntity
      .status(201)
      .body(service.createUser(userDTO, jwt));
  }

  @PutMapping
  public ResponseEntity<UserResponseDTO> updateUser(@Valid @RequestBody UserDTO userDTO, Jwt jwt) {
    return ResponseEntity.ok(service.updateUser(userDTO, jwt));
  }

  @DeleteMapping
  public void deleteUser(Jwt jwt) {
    service.deleteUser(jwt);
  }
}
