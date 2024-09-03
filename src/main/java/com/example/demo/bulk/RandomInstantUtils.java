package com.example.demo.bulk;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class RandomInstantUtils {

    /** Example
     * @param startDate 2023-01-01
     * @param endDate 2024-04-02
     */
    public static Instant getRandomInstant(String startDate, String endDate) {
        try {
            // String을 LocalDate로 변환
            LocalDate startLocalDate = LocalDate.parse(startDate);
            LocalDate endLocalDate = LocalDate.parse(endDate);

            // LocalDate를 Instant로 변환 (시작일의 자정, 끝날짜의 자정)
            Instant startInclusive = startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Instant endExclusive = endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

            if (startInclusive.isAfter(endExclusive)) {
                throw new IllegalArgumentException("Start date must be before end date");
            }

            long startMillis = startInclusive.toEpochMilli();
            long endMillis = endExclusive.toEpochMilli();

            Random random = new Random();
            long randomMillisSinceEpoch = startMillis + (long) (random.nextDouble() * (endMillis - startMillis));

            return Instant.ofEpochMilli(randomMillisSinceEpoch);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD format.", e);
        }
    }
}
