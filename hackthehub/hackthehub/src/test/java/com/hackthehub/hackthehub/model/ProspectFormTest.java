package com.hackthehub.hackthehub.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProspectFormTest {

    @Test
    void testConstructor() {
        final var prospect = ProspectForm.builder()
                .contractType("housing")
                .name("bruno")
                .address("Hack the Hub rd, 13")
                .amountPpm(100d).build();
    }

    @Test
    void toJson() {
        final var prospect = new ProspectForm(
                "housing",
                "Bruno",
                "male",
                "Hack The Hub Rd, 13",
                100d);
        final var prospectJson = prospect.toJson();
        assertThat(prospectJson).isNotNull();
        System.out.println(prospectJson);
    }
}