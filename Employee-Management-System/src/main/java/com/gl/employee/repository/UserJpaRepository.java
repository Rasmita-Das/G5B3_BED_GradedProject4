package com.gl.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.employee.model.User;

public interface UserJpaRepository extends JpaRepository<User, Integer>{
  Optional<User> findByUsername(String username);
}
