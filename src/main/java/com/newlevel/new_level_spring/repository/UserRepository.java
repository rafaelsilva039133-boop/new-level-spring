package com.newlevel.new_level_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newlevel.new_level_spring.model.User;

public interface UserRepository extends JpaRepository <User, Long> {}
