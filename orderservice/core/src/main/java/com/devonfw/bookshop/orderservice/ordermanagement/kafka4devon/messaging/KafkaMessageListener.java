package com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
@Service
public class KafkaMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageSender.class);

    @Autowired
    private MessageConverter converter;

    @Autowired
    private UcManageCustomerImpl manageCustomer;

    @KafkaListener(topics = "customer")
    public void receive(
                        @Payload String message,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp) throws IOException {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity = converter.convertJsonToObject(message, CustomerEntity.class);
        customerEntity.setName("bauerrrr");
        LOG.info("- - - - - - - - - - - - - - -");
        LOG.info("Received Message: {}", customerEntity.getId());
        LOG.info("topic: {}", topic);
        LOG.info("partition id: {}", partitionId);
        LOG.info("offset: {}", offset);
        LOG.info("timestamp type: {}", timestampType);
        LOG.info("timestamp: {}", timestamp);

        manageCustomer.updateCustomer1(customerEntity.getId());
    }

    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dltListen(Object in) {
        LOG.info("Received from DLT: " + in);
    }
}
*/
