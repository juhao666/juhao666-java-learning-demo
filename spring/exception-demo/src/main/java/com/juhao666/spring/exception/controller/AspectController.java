package com.juhao666.spring.exception.controller;

import com.juhao666.spring.exception.enums.MessageEnum;
import com.juhao666.spring.exception.exception.ApiException;
import com.juhao666.spring.exception.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AspectController {
    @GetMapping("/success")
    public Result aspect(String msg){
        log.info("this is success controller...");
        return Result.success(msg);
    }

    @GetMapping("/exception")
    public  Result exception(String msg){
        log.info("this is exception controller...");
        throw new RuntimeException("encounter unknown runtime exception...");
    }

    @GetMapping("/api/exception")
    public  Result apiException(String msg){
        log.info("this is api exception controller...");
        throw new ApiException(MessageEnum.ERROR);
    }

}
