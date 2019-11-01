package com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.Retry.annotation;

import java.time.Clock;

public @interface RetryPolicy {
    String id();

    String topic();

    int retries();

    String deadLetterTopic();

    long retryInterval() default 1L;
}
