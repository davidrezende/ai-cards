package com.aicards.dataprovider;

import com.aicards.entity.event.EventVO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducerProvider implements EventProducerProvider {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void sendMessage(String queueName, EventVO event) {
        rabbitTemplate.convertAndSend(queueName, event);
    }
}
