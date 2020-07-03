package com.captain.demo.mq.receiver;

import com.captain.demo.database.mybatis.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//
public class ObjectReceiver {

    @RabbitListener(queues = "aaaaaaaa.bbbbbbbb")
    @RabbitHandler
    public void process(User user) throws Exception {
    }

}
