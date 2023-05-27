package com.aicards.entrypoint.http.rabbit;

import com.aicards.entity.event.EventVO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queueName, EventVO vo) {
        rabbitTemplate.convertAndSend(queueName, vo);
    }
}
