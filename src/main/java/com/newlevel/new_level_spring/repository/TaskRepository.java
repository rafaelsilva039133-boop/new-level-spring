package com.newlevel.new_level_spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlevel.new_level_spring.model.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {


  List<Task> findAllByUserId(String userId);

  Optional<Task> findByIdAndUserId(Long id, String userId);
}
