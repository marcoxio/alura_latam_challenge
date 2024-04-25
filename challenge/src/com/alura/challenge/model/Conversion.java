package com.alura.challenge.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record Conversion(
        String baseCurrency,
        String targetCurrency,
        double originalValue,
        double convertedValue,
        double exchangeRate,
        LocalDateTime timestamp
) {
    public Conversion {
        timestamp = LocalDateTime.now();
    }
}

