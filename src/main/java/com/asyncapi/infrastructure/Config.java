package com.asyncapi.infrastructure;

import com.asyncapi.model.AnonymousSchema1;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class Config {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;

  @Value("${spring.kafka.listener.poll-timeout}")
  private long pollTimeout;

  @Value("${spring.kafka.listener.concurrency}")
  private int concurrency;

  @Bean
  KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, AnonymousSchema1>>
        kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<Integer, AnonymousSchema1> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    factory.setConcurrency(concurrency);
    factory.getContainerProperties().setPollTimeout(pollTimeout);
    return factory;
  }

  @Bean
  public ConsumerFactory<Integer, AnonymousSchema1> consumerFactory() {
    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new IntegerDeserializer(),
        new JsonDeserializer<>(
            AnonymousSchema1.class));
  }

  @Bean
  public Map<String, Object> consumerConfigs() {
    Map<String, Object> props = new HashMap<>();
    //props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
    //props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
    //props.put(JsonDeserializer.TYPE_MAPPINGS,);
    props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.asyncapi.model");
    return props;
  }
}
