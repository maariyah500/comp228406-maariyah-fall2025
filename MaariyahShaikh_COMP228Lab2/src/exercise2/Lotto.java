package exercise2;

import java.util.Random;

public class Lotto {
    int[] values = new int[3];

    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(9) + 1;
        }
    }

    public int[] getValues() {
        return values;
    }
}