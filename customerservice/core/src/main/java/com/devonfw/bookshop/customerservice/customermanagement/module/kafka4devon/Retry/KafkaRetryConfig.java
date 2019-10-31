package com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.Retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;

import javax.validation.constraints.NotNull;


@Configuration
public class KafkaRetryConfig<K, V> {

    @Autowired
    private KafkaTemplate<K, V> kafkaTemplate;

    @Autowired
    private Environment environment;

    @Bean({"org.springframework.kafka.config.internalKafkaListenerEndpointRegistry"})
    @NotNull
    public KafkaListenerEndpointRegistry defaultKafkaListenerEndpointRegistry() {
        return new KafkaListenerEndpointRegistry();
    }

    @Bean({"org.springframework.kafka.config.internalKafkaListenerAnnotationProcessor"})
    @NotNull
    public KafkaRetryPolicy kafkaRetryPolicy() {
        return new KafkaRetryPolicy();
    }
}


