package org.training.account.service.util;

import java.util.concurrent.atomic.AtomicLong;

public class AccountNumberGenerator {

    private static final AtomicLong generator = new AtomicLong(6001040000001L);

    public static String generate() {
        return String.valueOf(generator.getAndIncrement());
    }
}
