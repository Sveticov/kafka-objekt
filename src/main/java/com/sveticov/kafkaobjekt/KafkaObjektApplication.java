package com.sveticov.kafkaobjekt;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import com.sveticov.kafkaobjekt.models.MyCar;
import com.sveticov.kafkaobjekt.serves.Receiver;
import com.sveticov.kafkaobjekt.serves.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaObjektApplication implements CommandLineRunner {

    @Autowired
    private Sender sender;

    @Autowired
    private Receiver receiver;

    public static void main(String[] args) {
        SpringApplication.run(KafkaObjektApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        MyCar car=new MyCar("germ","bmw","1");


        sender.send(car);

        receiver.showCar();
    }
}
