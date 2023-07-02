package com.juhao666.spring.druid.controller;
import com.juhao666.spring.druid.entity.User;
import com.juhao666.spring.druid.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public User get(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @PutMapping("/user")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.delete(id);
    }

    @GetMapping
    public Page<User> list(@RequestParam(defaultValue = "id") String column,
                           @RequestParam(defaultValue = "ASC") Sort.Direction direction,
                           @RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "10") Integer size){
        Pageable pageable = PageRequest.of(page, size, direction,column);
        return userService.list(pageable);
    }

    @GetMapping("/name/{name}")
    public List<User> name(@PathVariable String name){
        return userService.getUsers(name);
    }
}

