package com.example.demo.bulk;

import java.util.Random;

public class RandomEnumUtils {

    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        Random random = new Random();
        T[] enumConstants = enumClass.getEnumConstants();
        int index = random.nextInt(enumConstants.length);
        return enumConstants[index];
    }
}
