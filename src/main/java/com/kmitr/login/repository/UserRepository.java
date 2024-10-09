package com.kmitr.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmitr.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
