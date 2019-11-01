package com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.messaging;

import com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.serializer.MessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.io.IOException;

@Service
public class KafkaMessageSender {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageSender.class);

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    private MessageConverter converter;


    public <T> void sendMessage(T message, String topic, String key, String partition) throws IOException {
        String payload = converter.convertMessageToJson(message);

        Message<String> msg = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                .setHeader(KafkaHeaders.PARTITION_ID, partition)
                .build();

        //Create the message and send it asynchronously
        createAndSendRecord(msg);
    }

    //Send message asynchronously
    private void createAndSendRecord(Message message){
        ListenableFuture<SendResult<Object, Object>> future = kafkaTemplate.send(message);
        Assert.notNull(message, "Parameter may not be zero");
        future.addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {

            @Override
            public void onSuccess(final SendResult<Object,Object> message) {
                LOG.info("sent message= " + message + " with offset= " + message.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(final Throwable throwable) {
                LOG.error("unable to send message= " + message, throwable);
            }
        });
    }
}
