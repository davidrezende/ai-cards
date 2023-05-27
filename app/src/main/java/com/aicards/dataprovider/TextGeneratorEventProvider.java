package com.aicards.dataprovider;

import com.aicards.dataprovider.model.Card;
import com.aicards.dataprovider.repository.CardRepository;
import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.EventVO;
import com.aicards.entity.vo.TextGenEvent;
import com.aicards.entrypoint.http.rabbit.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

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
