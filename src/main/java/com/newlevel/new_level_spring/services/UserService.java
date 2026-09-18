package com.newlevel.new_level_spring.services;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.exception.ResponsiveStatusExeption;
import com.newlevel.new_level_spring.model.DTOS.UserRequestDTO;
import com.newlevel.new_level_spring.model.DTOS.UserResponseDTO;
import com.newlevel.new_level_spring.model.User;
import com.newlevel.new_level_spring.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
  
  private final UserRepository userRepository;
  //Metodos externos
  public UserResponseDTO getCurrentUser(Jwt jwt) {

    String auth0Id = jwt.getSubject();

    User user = userRepository.findById(auth0Id)
      .orElseThrow(() ->
        new ResponsiveStatusExeption("Usuário não encontrado")
      );
    return toResponseDTO(user);
  }

  public UserResponseDTO createUser(UserRequestDTO userDTO, Jwt jwt) {

    String auth0Id = jwt.getSubject();

    if (existUserById(auth0Id)) {
      throw new ResponsiveStatusExeption("Usuário já existe");
    }

    User newUser = User.builder()
      .auth0Id(auth0Id)
      .name(userDTO.getName())
      .build();

    User savedUser = userRepository.save(newUser);

    return toResponseDTO(savedUser);
  }

  public UserResponseDTO updateUser(UserRequestDTO userDTO, Jwt jwt) {

    String auth0Id = jwt.getSubject();

    User user = userRepository.findById(auth0Id)
      .orElseThrow(() ->
        new ResponsiveStatusExeption("Usuário não encontrado")
      );

    user.setName(userDTO.getName());

    User updatedUser = userRepository.save(user);

    return toResponseDTO(updatedUser);
  }

  public void deleteUser(Jwt jwt) {

    String auth0Id = jwt.getSubject();

    User user = getUserById(auth0Id);

    userRepository.delete(user);
  }

  //Metodos externos

  public User getUserById(String auth0Id){
    return userRepository.findById(auth0Id)
      .orElseThrow(() -> 
        new ResponsiveStatusExeption("User not found")
      );
  }

  public Boolean existUserById(String auth0Id){
    return userRepository.existsById(auth0Id);
  } 

  private UserResponseDTO toResponseDTO(User user) {
    return UserResponseDTO
      .builder().auth0Id(user.getAuth0Id())
      .name(user.getName())
      .level(user.getLevel())
      .currentXp(user.getCurrentXp())
      .createdAt(user.getCreatedAt())
      .updatedAt(user.getUpdatedAt())
      .build();
  }

}
