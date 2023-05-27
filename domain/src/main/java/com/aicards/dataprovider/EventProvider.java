package com.aicards.dataprovider;

import com.aicards.entity.event.EventVO;

public interface EventProvider {
    void sendMessage(EventVO event);
}
