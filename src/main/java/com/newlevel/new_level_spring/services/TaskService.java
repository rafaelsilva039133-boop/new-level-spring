package com.newlevel.new_level_spring.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newlevel.new_level_spring.model.Task;

@Service
public class TaskService {

  private List<Task> tasksList = new ArrayList<>(Arrays.asList(new Task(1L, "Task 1", "Passear com cachorro"), new Task(2L, "Task 2", "Passear com gato")));

  public List<Task> getTasks(){
    return tasksList;
  }

  public Task geTaskById(Long taskId){
    return tasksList.stream().filter(t -> t.getId() == taskId).findFirst().get();
  }

  public void addTask(Task task){
    tasksList.add(task);
  }

  public void updateTask(Task task){
    tasksList.set(getIndex(task.getId()), task);
  }

  public void deleteTask(Long taskId){
    tasksList.remove(getIndex(taskId));
  }

    public int getIndex(Long userId){
    int i = 0;
    for (Task u : tasksList) {
      if (u.getId() == userId) {
        return i;
      }
      i++;
    }
    return -1;
  }
}
