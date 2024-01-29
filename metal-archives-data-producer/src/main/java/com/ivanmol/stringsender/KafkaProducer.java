package com.ivanmol.stringsender;

import com.ivanmol.stringsender.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Band band) {
        this.kafkaTemplate.send("one-band-topic", band);
    }

    public void produce(List<Band> bands) {
        kafkaTemplate.send("bands-topic", bands);
    }
}