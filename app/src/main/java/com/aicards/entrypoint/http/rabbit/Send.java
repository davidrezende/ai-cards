package com.aicards.entrypoint.http.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
    private static final String QUEUE_NAME = "teste";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (
                Connection connection = factory.newConnection();
                Channel channel = connection.createChannel();
        ) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String message = "Testando fila :)";
            channel.basicPublish("", QUEUE_NAME, null , message.getBytes());
            System.out.println(" Sent '" + message + "'");
        }
    }
}
