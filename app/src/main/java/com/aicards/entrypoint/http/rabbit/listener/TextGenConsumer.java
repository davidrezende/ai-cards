package com.aicards.entrypoint.http.rabbit.listener;

import com.aicards.entity.CardEntity;
import com.aicards.entity.event.impl.TextGenEvent;
import com.aicards.usecase.TextGeneratorUseCase;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${config.rabbit.queues.text-generator}")
public class TextGenConsumer {

    private final TextGeneratorUseCase textGenUseCase;

    public TextGenConsumer(TextGeneratorUseCase textGenUseCase) {
        this.textGenUseCase = textGenUseCase;
    }

    @RabbitHandler
    public void receive(TextGenEvent message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try{
            System.out.println("Message: " + message.toString());
            CardEntity cardUpdated = textGenUseCase.generateAndUpdateCard(message);
            channel.basicAck(tag, false);
        }catch (Exception e){
            throw new Exception("Erro ao processar evento de geracao de texto.");
        }
    }
}


