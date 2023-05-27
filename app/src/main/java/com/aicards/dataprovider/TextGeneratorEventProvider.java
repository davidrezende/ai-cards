package com.aicards.dataprovider;

import com.aicards.entity.event.EventVO;
import com.aicards.entrypoint.http.rabbit.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TextGeneratorEventProvider implements EventProvider{

    @Autowired
    private RabbitMQSender rabbit;

    @Value("${config.rabbit.queues.text-generator}")
    private String queueName;

    @Override
    public void sendMessage(EventVO event) {
        rabbit.send(queueName, event);
//        rabbit.send(queueName, new TextGenEvent("TESTE", "teste"));
    }
}
