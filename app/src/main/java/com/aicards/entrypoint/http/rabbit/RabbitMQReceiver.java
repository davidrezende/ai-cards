package com.aicards.entrypoint.http.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${config.rabbit.queue-name}")
public class RabbitMQReceiver {

    @RabbitHandler
    public void receive(String order, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        System.out.println("Message: " + order);
        channel.basicAck(tag, false);

    }
}
