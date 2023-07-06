package com.juhao666.rabbitmq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rabbit")
public class RabbitProducerController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * simple mode
     *
     * @param routeKey
     * @param message
     */
    @PostMapping("/simple")
    public void simple(@RequestParam String routeKey, @RequestParam String message) {
        log.info("send routeKey:" + routeKey + " send message:" + message);
        rabbitTemplate.convertAndSend(routeKey, message);
    }

    /**
     * work queue mode
     *
     * @param routeKey
     * @param message
     */
    @PostMapping("/work")
    public void work(@RequestParam String routeKey, @RequestParam String message) {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend(routeKey, "The " + String.valueOf(i) + " record message:" + message);
        }
    }


}
