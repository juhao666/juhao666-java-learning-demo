package com.juhao666.spring.exception.exception;

import com.juhao666.spring.exception.enums.MessageEnum;
import lombok.Data;

@Data
public class ApiException extends RuntimeException {

    private Integer code;

    public ApiException(MessageEnum messageEnum) {
        super(messageEnum.getMessage());
        this.code = messageEnum.getCode();
    }

    public ApiException(String message) {
        super(message);
        this.code = 500;
    }

}
