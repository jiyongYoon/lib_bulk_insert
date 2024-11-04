package com.example.demo.bulk;

import java.util.Random;

public class RandomIntUtils {

    public static int getRandomInt(int boundary) {
        Random random = new Random();
        return random.nextInt(boundary);
    }

    public static int getRandomNaturalInt(int boundary) {
        Random random = new Random();
        return random.nextInt(boundary) + 1;
    }

    public static Integer getRandomInteger(int boundary) {
        return getRandomInt(boundary);
    }
}
