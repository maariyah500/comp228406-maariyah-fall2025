package exercise2;

import java.util.Random;

public class Lotto {
    // array that hold 3 random integer values
    int[] values = new int[3];

    // default constructor
    public Lotto() {
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(9) + 1;
        }
    }

    // return values
    public int[] getValues() {
        return values;
    }
}