package com.hackthehub.hackthehub.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.clients.producer.ProducerConfig.*;

@Configuration
public class KafkaConfig {

//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(
//                Map.of(
////                        BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
//                        RETRIES_CONFIG, 0,
//                        BUFFER_MEMORY_CONFIG, 33554432,
//                        KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
//                        VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class
//                ));
//    }



    @Value(value = "${spring.kafka.properties.bootstrap.servers}")
    private String bootstrapAddress;

//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }

    @Bean
    public NewTopic getTopic() {
        return new NewTopic("contract-prospect", 1, (short) 1);
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put("security.protocol", "SASL_SSL");
        configProps.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='JQALMX2G45H52X3Q'   password='eJQEzQEiAposVGN+PH1wXpMPOxROVWf8+81g9+w7t52/HO1N20vc6/UoE2FOqBWN';");
        configProps.put("sasl.mechanism", "PLAIN");
        configProps.put("properties.client.dns.lookup", "use_all_dns_ips");
        configProps.put("acks", "all");
        configProps.put("cloud.stream.kafka.binder.replicationFactor", 1);
        configProps.put("spring.cloud.stream.kafka.streams.binder.configuration.replication.factor", 1);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
