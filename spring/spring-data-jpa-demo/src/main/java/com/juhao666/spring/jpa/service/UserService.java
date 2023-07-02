package com.juhao666.spring.jpa.service;

import com.juhao666.spring.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User getUser(int id);

    void create(User user);

    void update(User user);
    //different parameter type here.
    void delete(Integer id);
    Page<User> list(Pageable pageable);

    List<User> getUsers(String name);
}
