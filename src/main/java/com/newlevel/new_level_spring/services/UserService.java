package com.newlevel.new_level_spring.services;

//import java.util.ArrayList;
//import java.util.Arrays;
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


  public User getUserById(Long userId){
    return userRepository.findById(userId).orElseThrow(() -> new ResponsiveStatusExeption("User not found"));
  }
 
  public User addUser(UserDTO userDTO){
    User user = User.builder().name(userDTO.getName()).build();

    return userRepository.save(user);

  }
/*
  public void updateUser(User user){
    userslList.set(getIndex(user.getId()), user); 
  }

  public void deleteUser(Long userId){
    userslList.remove(getIndex(userId));
  }

  public int getIndex(Long userId){
    int i = 0;
    for (User u : userslList) {
      if (u.getId() == userId) {
        return i;
      }
      i++;
    }
    return -1;
  }
    */
}
