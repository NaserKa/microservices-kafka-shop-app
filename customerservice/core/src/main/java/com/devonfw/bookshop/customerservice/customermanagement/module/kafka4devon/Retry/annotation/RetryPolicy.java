package com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.Retry.annotation;

public @interface RetryPolicy {
    String id();

    String topic();

    int retries();

    String deadLetterTopic();

    long retryInterval() default 1L;
}
