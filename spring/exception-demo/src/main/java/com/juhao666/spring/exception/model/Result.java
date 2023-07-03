package com.juhao666.spring.exception.model;

import com.juhao666.spring.exception.enums.MessageEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    Integer code;
    String message;
    T data;

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(MessageEnum.SUCCESS.getCode(), MessageEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error() {
        return error(MessageEnum.ERROR);
    }

    public static <T> Result<T> error(MessageEnum error) {
        return new Result<>(error.getCode(), error.getMessage(), null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(MessageEnum.ERROR.getCode(), message, null);
    }

    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}
