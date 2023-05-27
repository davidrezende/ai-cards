package com.aicards.dataprovider;

import com.aicards.entity.CardEntity;
import com.aicards.entity.vo.EventVO;

import java.util.List;

public interface EventProvider {
    void sendMessage(EventVO event);
}
