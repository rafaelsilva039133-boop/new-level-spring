package com.newlevel.new_level_spring.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.User;

@Service
public class UserService {
  

  List<User> userslList = Arrays.asList(new User("123", "Rafa", 1, 20), new User("12233", "Timo", 5, 30));

  public List<User> getUsers(){
    return userslList;
  }

  public Object getUserById(String userId){
    for (int i = 0; i < userslList.size(); i++){
      if ( userId.equals(userslList.get(i).getId()) ) {
        return userslList.get(i);
      }
    }
    return null;
  }
}
