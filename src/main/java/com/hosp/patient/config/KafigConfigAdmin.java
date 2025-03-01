package com.hosp.patient.config;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import java.util.HashMap;

@Configuration
public class KafigConfigAdmin {

    private final KafkaProperties kafkaProperties;

    public KafigConfigAdmin(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }
    @Bean
    public KafkaAdmin kafkaAdmin() {
    var configs = new HashMap<String, Object>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    return new KafkaAdmin(configs);
    }

    @Bean
    KafkaAdmin.NewTopics  newTopics() {
       return new  KafkaAdmin.NewTopics(TopicBuilder.name("Hospital").replicas(1).partitions(3).build());
    }
}
