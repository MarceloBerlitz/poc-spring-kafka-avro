package dev.berlitz.poc.spring.kafka;

import dev.berlitz.avro.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class Controller {

    @Autowired
    private Producer producer;

    @PostMapping("person")
    public void addToQueue(@RequestBody PersonModel personModel) {
        producer.sendMessage("persons", Person.newBuilder()
            .setName(personModel.getName()).build());
    }

}
