package com.juhao666.spring.aop.enums;


import lombok.Getter;

@Getter
public enum MessageEnum {
    ERROR(500,"system error"),
    SUCCESS(0,"success"),
    ;
    private Integer code;
    private String message;

    MessageEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
