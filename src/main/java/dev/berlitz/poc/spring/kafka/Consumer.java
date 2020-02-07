package dev.berlitz.poc.spring.kafka;

import dev.berlitz.avro.Person;
import org.apache.avro.specific.SpecificData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "persons", groupId = "id")
    public void myConsumer(ConsumerRecord<String, Person> record) {
        Person customer = (Person) SpecificData.get().deepCopy(Person.SCHEMA$, record.value());
        System.out.println("Nome enviado: " + customer.getName());
    }
}
