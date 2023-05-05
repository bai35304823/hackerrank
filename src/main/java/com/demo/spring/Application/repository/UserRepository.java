package com.demo.spring.Application.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring.Application.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
