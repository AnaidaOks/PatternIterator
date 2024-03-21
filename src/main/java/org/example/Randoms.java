package org.example;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    private int minValue;
    private int maxValue;

    public Randoms (int min, int max) {
        this.minValue = min;
        this.maxValue = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        System.out.println("maxValue: " + maxValue + ", minValue: " + minValue);
        random = new Random();
        return new Iterator<Integer>() {
            int nextNo = random.nextInt(maxValue - minValue + 1) + minValue;

            @Override
            public boolean hasNext() {
                if (nextNo <= maxValue && nextNo >= minValue) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public Integer next() {
                if (nextNo <= maxValue && nextNo >= minValue) {
                    int retValue = nextNo;
                    nextNo = random.nextInt(maxValue - minValue + 1) + minValue;
                    return retValue;
                } else {
                    return nextNo;
                }
            }
        };
    }
}
