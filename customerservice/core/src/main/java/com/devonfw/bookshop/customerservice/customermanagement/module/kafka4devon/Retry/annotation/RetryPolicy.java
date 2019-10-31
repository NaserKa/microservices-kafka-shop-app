package com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.Retry.annotation;

import com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.Retry.BackOffStrategy;

import java.time.Clock;

public @interface RetryPolicy {
    String id();

    String topic();

    int retries();

    String deadLetterTopic();

    long retryInterval() default 1L;

    BackOffStrategy backoffStrategy() default backoffStrategy().backOffStrategyRandom(Clock.systemUTC(), 4, 100L);
}
