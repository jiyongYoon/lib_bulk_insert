package com.example.demo.bulk;

import java.util.Random;

public class RandomBoolUtils {

    public static boolean getRandomBool() {
        Random random = new Random();
        int i = random.nextInt(2);
        return i % 2 == 0;
    }

    public static Boolean getRandomInteger() {
        return getRandomBool();
    }
}
