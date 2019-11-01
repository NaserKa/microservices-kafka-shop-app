package com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageConverter {
    private static final Logger LOG = LoggerFactory.getLogger(MessageConverter.class);


    @Autowired
    private ObjectMapper objectMapper;

    public <T> String convertMessageToJson(T message) throws JsonProcessingException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);

        if (message == null) {
            throw new IllegalArgumentException();
        }

        LOG.info(message.toString());
        return objectMapper.writeValueAsString(message);
    }

    public <T> T convertJsonToObject(String message, Class<T> valueType) throws IOException {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        objectMapper.registerModule(javaTimeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.setDateFormat(new StdDateFormat());

        if (valueType == null) {
            throw new IllegalArgumentException();
        }

        return (T) objectMapper.readValue(message, valueType);
    }
}
