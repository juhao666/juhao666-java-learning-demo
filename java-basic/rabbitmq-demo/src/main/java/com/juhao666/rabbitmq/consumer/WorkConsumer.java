package com.juhao666.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class WorkConsumer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiveOne(String message) {
        log.info("{} consumed by receiveOne", message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receiveTwo(String message) {
        log.info("{} consumed by receiveTwo", message);
    }
}
