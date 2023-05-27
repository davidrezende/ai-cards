package com.aicards.dataprovider;

import com.aicards.entity.event.EventVO;

public interface EventProducerProvider {
    void sendMessage(String queueName, EventVO event);
}
