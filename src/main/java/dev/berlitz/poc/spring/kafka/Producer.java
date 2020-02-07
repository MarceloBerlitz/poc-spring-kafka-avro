package dev.berlitz.poc.spring.kafka;

import dev.berlitz.avro.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    public void sendMessage(String topic, Person person) {
        kafkaTemplate.send(topic, person);
    }

}
