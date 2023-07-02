package com.juhao666.spring.druid.dao;

import com.juhao666.spring.druid.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findByNameContaining(String name);

}
