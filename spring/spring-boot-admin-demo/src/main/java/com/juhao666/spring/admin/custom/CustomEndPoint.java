package com.juhao666.spring.admin.custom;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="customEndPoint")
public class CustomEndPoint {

    @ReadOperation
    public Map<String, String> raad(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "custom endpoint");
        return map;
    }

    @WriteOperation
    public Map<String, String> write(String name){
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " updated");
        return map;
    }

    @DeleteOperation
    public Map<String, String> delete(String name){
        Map<String, String> map = new HashMap<>();
        map.put("message", name + " deleted");
        return map;
    }
}
