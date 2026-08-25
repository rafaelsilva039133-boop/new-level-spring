package com.newlevel.new_level_spring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.User;

@Service
public class UserService {
  

  List<User> userslList = new ArrayList<>(Arrays.asList(new User(1L, "Rafa", 1, 20), new User(2L, "Timo", 5, 30)));

  public List<User> getUsers(){
    return userslList;
  }

  public User getUserById(Long userId){
    for (int i = 0; i < userslList.size(); i++){
      if ( userId == userslList.get(i).getId() ) {
        return userslList.get(i);
      }
    }
    return null;
  }

  public void addUser(User user){
    userslList.add(user);
  }

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
}
