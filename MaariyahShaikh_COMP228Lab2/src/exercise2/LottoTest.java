package exercise2;

import javax.swing.*;

public class LottoTest {
    public static void main(String[] args) {

        for (int count = 1; count <= 5; count++) {
            Lotto lotto = new Lotto();
            int[] numbers = lotto.getValues();

            int sum = 0;
            for (int number : numbers) {
                sum += number;
            }

            System.err.println("Attempt" +
                    "#" + count + ": " +
                    lotto.getValues()[0] + "+" +
                    lotto.getValues()[1] + "+" +
                    lotto.getValues()[2] + "=" +
                    sum);

            int userInput = Integer.parseInt(JOptionPane.showInputDialog(
                    "Choose a number between 3 and 27: \nAttempt #" + count + ":"));

            if (sum == userInput) {
                JOptionPane.showMessageDialog(null, "You win!");
                break;
            } else {
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