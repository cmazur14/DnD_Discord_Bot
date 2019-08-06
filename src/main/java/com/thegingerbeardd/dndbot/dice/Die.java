package com.thegingerbeardd.dndbot.dice;

import java.util.Random;

public class Die {
    private int maxNum;
    Random rng;

    public Die(int max) {
        maxNum = max;
        rng = new Random();
    }

    public int roll() {
        return rng.nextInt(maxNum) + 1;
    }

    public int roll(int modifier) {
        return rng.nextInt(maxNum) + 1 + modifier;
    }

    public void refreshRandomAlgorithm() {
        rng = new Random();
    }
}
