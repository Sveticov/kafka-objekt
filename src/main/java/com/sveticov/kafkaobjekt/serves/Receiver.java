package com.sveticov.kafkaobjekt.serves;

import com.sveticov.kafkaobjekt.models.MyCar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {

    private static final Logger log=LoggerFactory.getLogger(Receiver.class);

MyCar myCar=new MyCar();

    @KafkaListener(topics = "${kafka.topic.example}")
    public void receive(@Payload MyCar car, @Headers MessageHeaders headers){

        log.info("received car='{}'",car);

        myCar=car;

        headers.keySet().forEach(key->{
            log.info("{}: {}",key,headers.get(key));
        });
    }

    public void showCar(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("show my car: "+myCar);
    }
}
