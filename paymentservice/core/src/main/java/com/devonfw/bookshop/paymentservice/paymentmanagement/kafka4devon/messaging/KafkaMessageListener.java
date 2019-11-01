package com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.messaging;

import com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.PaymentEntity;
import com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.serializer.MessageConverter;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.impl.usecase.UcFindPaymentImpl;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.impl.usecase.UcManagePaymentImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class KafkaMessageListener {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaMessageSender.class);

    @Autowired
    private MessageConverter converter;

    @Autowired
    private UcManagePaymentImpl managePayment;

    @Autowired
    private UcFindPaymentImpl findPayment;

    @KafkaListener(topics = "order_payment")
    public void receive(
                        @Payload String message,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.TIMESTAMP_TYPE) String timestampType,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                        @Header(KafkaHeaders.RECEIVED_TIMESTAMP) Long timestamp) throws IOException {
        String orderId = message;

        LOG.info("- - - - - - - - - - - - - - -");
        LOG.info("Received Message: {}", message);
        LOG.info("topic: {}", topic);
        LOG.info("partition id: {}", partitionId);
        LOG.info("offset: {}", offset);
        LOG.info("timestamp type: {}", timestampType);
        LOG.info("timestamp: {}", timestamp);

        managePayment.savePaymentById(Long.parseLong(orderId));
        LOG.info("timestamp: {}", timestamp);
    }

    @KafkaListener(id = "dltGroup", topics = "topic1.DLT")
    public void dltListen(Object in) {
        LOG.info("Received from DLT: " + in);
    }

    public class OrderPayment {

    }
}



