package exercise2;

import javax.swing.*;

// Ex.2
public class Main {
    public static void main(String[] args) {
        System.out.println("Ex. 2");
        System.out.println("=====================");

        // play Lotto for 5 rolls
        for (int count = 1; count <= 5; count++) {
            // 3 random numbers and the respective sum will be generated in each rolls
            Lotto lotto = new Lotto();
            int[] numbers = lotto.getValues();

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            // debug log
            System.err.println("Debug attempt " +
                    "#" + count + ": " +
                    lotto.getValues()[0] + "+" +
                    lotto.getValues()[1] + "+" +
                    lotto.getValues()[2] + "=" +
                    sum);

            // prompt for user input
            int userInput = Integer.parseInt(JOptionPane.showInputDialog(
                    "Choose a number between 3 and 27: \nAttempt #" + count + ":"));

            // game ends immediately if user input matches the sum
            if (sum == userInput) {
                JOptionPane.showMessageDialog(null, "You win!");
                break;
            } else { // play again until the 5th rolls
                if (count == 5) {
                    JOptionPane.showMessageDialog(null, "Computer wins.");
                } else {
                    sum = 0;
                    lotto = new Lotto();
                }
            }
        }

    }
}