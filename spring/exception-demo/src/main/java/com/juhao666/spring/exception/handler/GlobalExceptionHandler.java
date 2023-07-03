package com.juhao666.spring.exception.handler;

import com.juhao666.spring.exception.enums.MessageEnum;
import com.juhao666.spring.exception.exception.ApiException;
import com.juhao666.spring.exception.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<Boolean> globalException(Exception e){
        Result<Boolean> result = new Result<>();
        result.setCode(MessageEnum.ERROR.getCode());
        result.setMessage(e.getMessage()==null? MessageEnum.ERROR.getMessage() : e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }

    @ExceptionHandler(ApiException.class)
    public Result<Boolean> apiException(ApiException e){
        Result<Boolean> result = new Result<>();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        log.error(e.getMessage(),e);
        return result;
    }

}
