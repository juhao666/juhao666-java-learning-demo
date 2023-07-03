package com.juhao666.spring.druid.service.impl;

import com.juhao666.spring.druid.dao.UserDao;
import com.juhao666.spring.druid.entity.User;
import com.juhao666.spring.druid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;
    @Override
    public User getUser(int id) {
        return dao.findById(id).get();
    }

    @Override
    public void create(User user) {
        dao.save(user);
    }

    @Override
    public void update(User user) {
        dao.save(user);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public Page<User> list(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public List<User> getUsers(String name) {
        return dao.findByNameContaining(name);
    }
}
