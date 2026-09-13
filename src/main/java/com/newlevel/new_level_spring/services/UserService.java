package com.newlevel.new_level_spring.services;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.exception.ResponsiveStatusExeption;
import com.newlevel.new_level_spring.model.DTOS.UserDTO;
import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
  
  private final UserRepository userRepository;

  public ResponseEntity<?> me(Jwt jwt) {
    String userId = jwt.getSubject();

    return ResponseEntity.ok(Map.of(
      "userId", userId
    ));
  }

  public List<User> getUsers(){
    return userRepository.findAll();
  }

  public User createUser(UserDTO userDTO) {
    if (existUserById(userDTO.getAuth0Id())) {
      throw new ResponsiveStatusExeption("Usuário já existe");
    }
    
    User newUser = User.builder()
      .auth0Id(userDTO.getAuth0Id())
      .name(userDTO.getName())
      .build();
    
    return userRepository.save(newUser);
  }

  public User updateUser(UserDTO userDTO) {
    return userRepository.findById(userDTO.getAuth0Id())
      .map(existingUser -> {
        existingUser.setName(userDTO.getName());
        return userRepository.save(existingUser);
      })
      .orElseThrow(() -> new ResponsiveStatusExeption("Usuário não encontrado: " + userDTO.getAuth0Id()));
  }

  public User getUserById(String auth0Id){
    return userRepository.findById(auth0Id).orElseThrow(() -> new ResponsiveStatusExeption("User not found"));
  }

  public Boolean existUserById(String auth0Id){
    return userRepository.existsById(auth0Id);
  } 

  public void deleteUser(String userId){
    userRepository.delete(getUserById(userId));
  }

}
