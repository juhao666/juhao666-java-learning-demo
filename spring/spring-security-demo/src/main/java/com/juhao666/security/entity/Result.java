package com.juhao666.security.entity;


import com.juhao666.security.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private Integer code;
    private String message;
    private Object data;

    public Result(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.messag();
        this.data = data;
    }
}

