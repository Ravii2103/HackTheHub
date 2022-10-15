package com.hackthehub.hackthehub.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackthehub.hackthehub.model.ProsepectForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsortiumService {

    @Autowired
    private KafkaService kafkaService;

    public boolean sendToAnalysis(ProsepectForm prospectForm) {
        // run some backend logic
        final String prospectAsJson;
        try {
            prospectAsJson = serializeToJson(prospectForm);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Faild to serialize into JSON", e);
        }
        kafkaService.sendTo("contract-prospect", prospectAsJson);
    }

    private String serializeToJson(ProsepectForm prospectForm) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(prospectForm);
    }
}
