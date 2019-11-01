package com.devonfw.bookshop.paymentservice.paymentmanagement.kafka4devon.Retry;

import java.time.Clock;
import java.util.Random;

public class BackOffStrategy {

    public final long backOffStrategyConstant(Clock clock, int iteration, long interval) {
        return clock.instant().plusSeconds(interval).getEpochSecond();
    }

    public final long backOffStrategyLinear(Clock clock, int iteration, long interval) {
        return clock.instant().plusSeconds((iteration + 1) * interval).getEpochSecond();
    }

    public final long backOffStrategyRandom(Clock clock, int iteration, long interval) {
        Random random = new Random();
        return clock.instant().plusSeconds(random(interval * (iteration + 1))).getEpochSecond();
    }

    public long random(long bound) {
        return (long)(new Random()).nextInt((int)bound);
    }
}
