package com.asyncapi.service;

import com.asyncapi.model.AnonymousSchema1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageHandlerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MessageHandlerService.class);

  @KafkaListener(topics = "light-measured", groupId = "asyncapi")
  public void onLightMeasured(@Payload AnonymousSchema1 payload,
      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
      @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
    LOGGER.info("Key: " + key + ", Payload: " + payload.toString() + ", Timestamp: " + timestamp
        + ", Partition: " + partition);
  }
}
