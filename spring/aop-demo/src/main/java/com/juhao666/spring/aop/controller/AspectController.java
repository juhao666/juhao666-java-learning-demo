package com.juhao666.spring.aop.controller;

import com.juhao666.spring.aop.model.Result;
import com.juhao666.spring.aop.services.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AspectController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/aspect")
    public  Result aspect(String msg){
        log.info("this is aspect controller...");
        return Result.success(msg);
    }

    @GetMapping("/exception")
    public  Result exception(String msg){
        log.info("this is exception controller...");
        throw new RuntimeException("encounter unknown runtime exception...");
    }

    @GetMapping("/sleep/{time}")
    public  Result sleep(@PathVariable("time") long time){
        log.info("this is sleep controller start...");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("this is sleep controller end...");
        return Result.success("elapsed time statistic...");
    }

    @GetMapping("/around")
    public  Result around(){
        log.info("this is around aspect controller...");
        String msg = demoService.getAround();
        return Result.success(msg);
    }

}
