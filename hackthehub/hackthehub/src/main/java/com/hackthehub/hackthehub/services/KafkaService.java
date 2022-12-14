package com.hackthehub.hackthehub.services;

import com.hackthehub.hackthehub.config.KafkaConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> template;

    @Autowired
    private KafkaConfig kafkaConfig;

    public void sendTo(String payload) {
        template.send(kafkaConfig.getTopic().name(), 0, Instant.now().getEpochSecond(), UUID.randomUUID().toString(), payload);
    }
}
