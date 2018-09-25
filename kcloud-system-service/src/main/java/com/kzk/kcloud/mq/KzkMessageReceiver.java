package com.kzk.kcloud.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class KzkMessageReceiver {

    @RabbitListener(queues = "testmq")
    @RabbitHandler
    public void processMsg(String msg){

        System.out.println("Redis: " + msg);
    }
}
