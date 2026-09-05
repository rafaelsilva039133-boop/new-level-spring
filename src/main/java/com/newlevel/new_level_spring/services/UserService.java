package com.newlevel.new_level_spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.model.DTOS.UserDTO;
import com.newlevel.new_level_spring.repository.UserRepository;
import com.newlevel.new_level_spring.tools.ResponsiveStatusExeption;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
  
  private final UserRepository userRepository;

  public List<User> getUsers(){
    return userRepository.findAll();
  }

  public User createUser(UserDTO userDTO) {
    // Verifica se já existe
    if (existUserById(userDTO.getAuth0Id())) {
      throw new ResponsiveStatusExeption("Usuário já existe");
    }
    
    User newUser = User.builder()
      .auth0Id(userDTO.getAuth0Id())
      .name(userDTO.getName())
      .lastLoginAt(userDTO.getLastLoginAt())
      .build();
    
    return userRepository.save(newUser);
  }

  public User updateUser(UserDTO userDTO) {
    return userRepository.findById(userDTO.getAuth0Id())
      .map(existingUser -> {
        existingUser.setName(userDTO.getName());
        existingUser.setLastLoginAt(userDTO.getLastLoginAt());
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
