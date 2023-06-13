package com.aicards.entrypoint.http.rabbit.listener;

import com.aicards.entity.CardEntity;
import com.aicards.entity.event.impl.ImageGenEvent;
import com.aicards.usecase.ImageGeneratorCardUseCase;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${config.rabbit.queues.image-generator}")
public class ImageGenConsumer {

    private final ImageGeneratorCardUseCase imageGenUseCase;

    public ImageGenConsumer(ImageGeneratorCardUseCase imageGenUseCase){
        this.imageGenUseCase = imageGenUseCase;
    }

    @RabbitHandler
    public void receive(ImageGenEvent message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try{
            System.out.println("Message: " + message.toString());
            CardEntity cardUpdated = imageGenUseCase.generateAndUpdateCard(message);
        } catch (Exception e) {
            throw new Exception("Erro ao processar evento de geracao de imagem.");
        }
    }
}
