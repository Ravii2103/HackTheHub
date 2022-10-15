package com.hackthehub.hackthehub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackthehub.hackthehub.model.ProspectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsortiumService {

    @Autowired
    private KafkaService kafkaService;

    public void sendToAnalysis(ProspectForm prospectForm) {
        // run some backend logic (Machine Learning)...

        final String prospectAsJson;
        try {
            prospectAsJson = serializeToJson(prospectForm);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Faild to serialize into JSON", e);
        }
        kafkaService.sendTo(prospectAsJson);
    }

    private String serializeToJson(ProspectForm prospectForm) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(prospectForm);
    }
}
