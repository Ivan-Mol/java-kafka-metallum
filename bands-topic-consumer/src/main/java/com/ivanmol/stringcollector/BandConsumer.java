package com.ivanmol.stringcollector;

import com.ivanmol.stringcollector.model.Band;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BandConsumer {
    @KafkaListener(topics = "bands-topic", groupId = "band-info", properties = {"spring.json.value.default.type=java.util.List"})
    public void consumeCreatedBands(List<Band> bands, Acknowledgment acknowledgment) {
        System.out.println(String.format("Band : %s", bands));
        acknowledgment.acknowledge();
    }
}

