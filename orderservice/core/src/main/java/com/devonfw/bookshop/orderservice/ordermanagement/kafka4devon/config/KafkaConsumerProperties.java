package com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerProperties {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    private KafkaProducerProperties kafkaProducerProperties ;

    @Autowired
    private ConcurrentKafkaListenerContainerFactoryConfigurer concurrentKafkaListenerContainerFactoryConfigurer;

    @Value("${kafka.consumer.bootstrapservers}")
    private String bootstrapservers;

    @Value("${kafka.consumer.groupId}")
    private String groupId;

    @Value("${kafka.consumer.autocommitInterval}")
    private String autocommitInterval;

    @Value("${kafka.consumer.requestTimeoutms}")
    private String requestTimeoutms;

    @Value("${kafka.consumer.maxPollRecords}")
    private Integer maxPollRecords;

    @Value("${kafka.consumer.maxPollIntervalMs}")
    private Integer maxPollIntervalMs;

    @Value("${kafka.consumer.sessionTimeoutMs}")
    private Integer sessionTimeoutMs;

    @Value("${kafka.consumer.heartbeatIntervalMs}")
    private Integer heartbeatIntervalMs;

    @Value("${kafka.consumer.enableAutoCommit}")
    private Boolean enableAutoCommit = false;

    @Value("${kafka.consumer.autoOffsetReset}")
    private String autoOffsetReset = "earliest";

    @Value("${kafka.consumer.fetchMinBytes}")
    private Integer fetchMinBytes;

    @Value("${kafka.consumer.fetchMaxBytes}")
    private Integer fetchMaxBytes;

    @Value("${kafka.consumer.fetchMaxWaitMs}")
    private Integer fetchMaxWaitMs;

    @Value("${kafka.consumer.maxPartitionFetchBytes}")
    private Integer maxPartitionFetchBytes;

    @Value("${kafka.consumer.isolationLevel}")
    private String isolationLevel;

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapservers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autocommitInterval);

        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollIntervalMs);

        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeoutms);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatIntervalMs);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, fetchMinBytes);

        props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, fetchMaxBytes);
        props.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, fetchMaxWaitMs);

        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, maxPartitionFetchBytes);
        props.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, isolationLevel);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    /*
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }*/


    @Bean
    public ConcurrentKafkaListenerContainerFactory kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckOnError(false);
        factory.setErrorHandler(new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(template), 3)
        );
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.RECORD);
        return factory;
    }

    @Bean
    public KafkaTemplate<Object, Object> template() {
        return new KafkaTemplate<Object, Object>(new KafkaProducerProperties().producerFactory());
    }
}
