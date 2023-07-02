package com.juhao666.spring.jpa.dao;

import com.juhao666.spring.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findByNameContaining(String name);

}
