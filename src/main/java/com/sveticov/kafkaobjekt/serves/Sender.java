package com.sveticov.kafkaobjekt.serves;

import com.sveticov.kafkaobjekt.models.MyCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    private static final Logger log=LoggerFactory.getLogger(Sender.class);

   @Value("${kafka.topic.example}")
    private String jsonTopic="example.t";

    @Autowired
    private KafkaTemplate<String,MyCar> kafkaTemplate;

    public void send(MyCar car){
        log.info("sending car='{}'",car.toString());
        Message<MyCar> message=MessageBuilder
                .withPayload(car)
                .setHeader(KafkaHeaders.TOPIC,jsonTopic)
                .build();
        kafkaTemplate.send(message);
    }
}
