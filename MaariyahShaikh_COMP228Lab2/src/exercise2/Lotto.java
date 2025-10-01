package exercise2;

import javax.swing.JOptionPane;
import java.util.Random;

public final class Lotto {
    private static final int MAX_ITERATIONS = 5;
    private static final int ARRAY_SIZE = 3;
    private static final int MAX_RANDOM = 9;
    private int[] numbers = new int[ARRAY_SIZE];

    public Lotto() {
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(MAX_RANDOM) + 1;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int sum() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public static void main(final String[] args) {
        String input = JOptionPane.showInputDialog("Number between 3 and 27: ");
        int userNumber = Integer.parseInt(input);

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            Lotto lotto = new Lotto();
            int sum = lotto.sum();
            if (sum == userNumber) {
                JOptionPane.showMessageDialog(null, "You win! The numbers were "
                        + lotto.getNumbers()[0] + ", "
                        + lotto.getNumbers()[1] + ", "
                        + lotto.getNumbers()[2]);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Computer wins!");
    }
}