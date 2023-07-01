package com.juhao666.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello demo coming...";
    }

    @GetMapping("/index")
    public String index() {
        return "hello index coming...";
    }

    @GetMapping("/admin")
    //@Secured({"ROLE_admin","ROLE_manager"})
    @PreAuthorize("hasAnyAuthority('admin')")
    //@PostAuthorize("hasAnyAuthority('admins')")
    public String admin() {
        System.out.println("access /demo/admin method already!!!!");
        return "hello my role is correct!!!";
    }

}
