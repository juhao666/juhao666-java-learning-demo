package com.juhao666.security.controller;

import com.juhao666.security.entity.Result;
import com.juhao666.security.enums.ResultCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/grace")
public class GraciouslyResponseDemoController {

    @GetMapping("{id}")
    public Result getResult(@PathVariable("id") Integer id) {
        HashMap<Object, Object> o = new HashMap<>();
        o.put("id", id);
        o.put("clazz", "GraciouslyResponseDemoController");
        Result result = new Result(ResultCode.SUCCESS, o);
        return result;
    }
}
