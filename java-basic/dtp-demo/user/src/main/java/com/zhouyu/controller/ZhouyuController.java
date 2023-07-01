package com.zhouyu.controller;

import org.dtp.DtpExecutor;
import org.dtp.utils.DtpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhouyuController {



    @GetMapping("/test")
    public Integer test(){
        DtpExecutor executor1 = DtpUtil.getDtpExecutor("p2");
        executor1.execute(()->{
            System.out.println("1");
            try {
                Thread.sleep(60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return executor1.getCorePoolSize();
    }
}
