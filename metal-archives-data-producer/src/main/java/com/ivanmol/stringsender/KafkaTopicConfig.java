package com.ivanmol.stringsender;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class KafkaTopicConfig {
    @Bean
    public NewTopic createBandTopic() {
        return TopicBuilder.name("one-band-topic")
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic createBandsTopic() {
        return TopicBuilder
                .name("bands-topic")
                .partitions(1)
                .build();
    }

}