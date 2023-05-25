package com.aicards.entrypoint.http;

import com.aicards.entrypoint.http.rabbit.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping("/{message}")
    public String producer(@PathVariable String message) {
        rabbitMQSender.send(message);
        return "Message sent to the RabbitMQ";
    }

}
