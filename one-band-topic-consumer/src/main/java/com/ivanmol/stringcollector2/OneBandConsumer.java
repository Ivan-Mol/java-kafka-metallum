package com.ivanmol.stringcollector2;

import com.ivanmol.stringcollector2.model.Band;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OneBandConsumer {

    @Component
    public class BandConsumer {
        @KafkaListener(topics = "one-band-topic", groupId = "band-info", properties = {"spring.json.value.default.type=com.ivanmol.stringcollector2.model.Band"})
        public void consumeCreatedBand(Band band, Acknowledgment acknowledgment) {
            System.out.println(String.format("Band : %s", band.toString()));
            acknowledgment.acknowledge();
        }
    }
}