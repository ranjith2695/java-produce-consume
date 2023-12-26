package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class Producer {

    public static void main(String[] args) {

        Properties prop = new Properties();

        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        System.out.println("started");
        for (int i=1000;i<=1050;i++){
            ProducerRecord<String, String> record = new ProducerRecord<>("test1" , "key2" , Integer.toString(i));
            producer.send(record);
        }

        producer.flush();
        System.out.println("flushed");
        producer.close();
    }


}
