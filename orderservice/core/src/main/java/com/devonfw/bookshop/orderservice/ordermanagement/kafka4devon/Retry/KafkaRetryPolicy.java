package com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.Retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.time.Clock;
/*
public class KafkaRetryPolicy<K, V> implements KafkaListenerErrorHandler{

    private static final Logger LOG = LoggerFactory.getLogger(KafkaRetryPolicy.class);

    private String REMAINING_RETRIES_HEADER = "remaining-retries";
    private String RETRY_TIMESTAMP_HEADER = "retry-timestamp";

    private KafkaTemplate<K, V> kafkaTemplate;
    private int maxRetries;
    private String retryTopic;
    private String deadLetterTopic;
    private long retryInterval;
    private BackOffStrategy backOffStrategy;
    private Clock clock= Clock.systemUTC();

    private String resolveTopicName(Environment environment, String key) {
        return environment.resolvePlaceholders(key);
    }

    public KafkaRetryPolicy(KafkaTemplate<K, V> kafkaTemplate, Environment environment) {
        super();
        this.kafkaTemplate = kafkaTemplate;
        this.maxRetries = policy.retries();
        this.retryTopic = resolveTopicName(environment, policy.topic());
        this.deadLetterTopic = resolveTopicName(environment, policy.deadLetterTopic());
        this.retryInterval = policy.retryInterval();
        this.backOffStrategy = policy.backoffStrategy();
        this.clock = clock;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        int remainingRetries = remainingRetries(message);

        MessageBuilder<?> messageBuilder = MessageBuilder
                .fromMessage(message)
                .removeHeader(KafkaHeaders.TOPIC)
                .removeHeader(KafkaHeaders.PARTITION_ID)
                .removeHeader(KafkaHeaders.MESSAGE_KEY)
                .setHeader(KafkaHeaders.TOPIC, targetTopic(remainingRetries));

        if (remainingRetries > 0) {

            LOG.info("Message handling error. [Retrial: ${maxRetries - remainingRetries + 1} of $maxRetries - Topic: $retryTopic]", e);

            messageBuilder
                    .setHeader(REMAINING_RETRIES_HEADER, remainingRetries - 1)
                    .setHeader(RETRY_TIMESTAMP_HEADER, retryTimestamp(remainingRetries));

        } else {

            LOG.info("Maximum message handling retries reached. Forwarding message to DLQ [Topic: $retryTopic - DLQ Topic: $dlqTopic]", e);
        }

        kafkaTemplate.send(messageBuilder.build());

        return remainingRetries;
    }

    private String targetTopic(int remainingRetries) {
        if (remainingRetries > 0){
            return retryTopic;
        }
        return deadLetterTopic;
    }


    private int remainingRetries(Message message) {
        MessageHeaders msg = message.getHeaders();
        Object obj = msg != null ? msg.get("remaining-retries") : null;
        if (!(obj instanceof Integer)) {
            obj = null;
        }

        return (Integer)obj != null ? (Integer)obj : this.maxRetries;
    }

    private Long retryTimestamp(int remainingRetries) {
        return  backOffStrategy.backOffStrategyConstant(clock, maxRetries - remainingRetries, retryInterval);
    }
}
*/
