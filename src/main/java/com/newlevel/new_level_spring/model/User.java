package com.newlevel.new_level_spring.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@Table(name = "users")
@NoArgsConstructor
@Builder
public class User {
  @Id
  @Column(name = "auth0_id", nullable = false, length = 100, updatable = false)
  private String auth0Id;

  @Column(name = "name")
  private String name;

  @Builder.Default
  @Column(name = "level")
  private int level = 0;

  @Builder.Default
  @Column(name = "current_xp")
  private int currentXp = 0;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt; // Quando foi criado
  
  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt; // Última atualização
  
  @Column(name = "last_login_at")
  private LocalDateTime lastLoginAt; // Último login
  
  @Builder.Default
  @Column(name = "is_active")
  private boolean active = true; // Se está ativo

}
