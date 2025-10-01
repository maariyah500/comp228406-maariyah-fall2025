package exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

public final class Test {
    public static void main(final String[] args) {
        Test test = new Test();
        test.inputAnswer();
    }

    private static final int MAX_ANSWER = 4;

    private final String[] questions = {
            "Question 1: Which of the following tools support the development of Java applications?",
            "Question 2: What is the main function of a Java Virtual Machine (JVM)?",
            "Question 3: Which of the following is a temporary variable used inside methods?",
            "Question 4: Which of the following is a directory containing one or more JavaScript files and other resources?",
            "Question 5: There are variables for which their value cannot be re-assigned after their initial declaration. They are called...",
    };

    private final String[][] options = {
            {"1. IDE", "2. JVM", "3. JDK", "4. API"},
            {
                    "1. Translates source code",
                    "2. Places program in memory",
                    "3. Executes bytecodes",
                    "4. Examines bytecodes",
            },
            {
                    "1. Local variable",
                    "2. Instance variable",
                    "3. Non-static Method",
                    "4. Class",
            },
            {"1. Function", "2. Method", "3. IDE", "4. Package"},
            {
                    "1. Class variables",
                    "2. Constant variables",
                    "3. Local variables",
                    "4. Instance variables",
            },
    };

    private final int[] answers = {3, 3, 1, 4, 2};

    private int score = 0;

    public void simulateQuestion(final int questionNumber) {
        String question = questions[questionNumber];
        String[] option = options[questionNumber];
        String answer;
        do {
            answer = JOptionPane.showInputDialog(
                    null,
                    question + "\n" + String.join("\n", option));
            if (!isValidAnswer(answer)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Invalid input. Enter a number between 1 and 4.");
            }
        } while (!isValidAnswer(answer));
        checkAnswer(questionNumber, answer);
    }

    private boolean isValidAnswer(final String answer) {
        try {
            int answerInt = Integer.parseInt(answer);
            return answerInt >= 1 && answerInt <= MAX_ANSWER;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void checkAnswer(final int questionNumber, final String answer) {
        if (Integer.parseInt(answer) == answers[questionNumber]) {
            score++;
            generateMessage(true);
        } else {
            generateMessage(false);
        }
    }

    public void generateMessage(final boolean isCorrect) {
        Random random = new Random();
        String message;
        switch (random.nextInt(MAX_ANSWER)) {
            case 0:
                message = isCorrect ? "Excellent!" : "No. Please try again";
                break;
            case 1:
                message = isCorrect ? "Good!" : "Wrong. Try once more";
                break;
            case 2:
                message = isCorrect
                        ? "Keep up the good work!"
                        : "Don't give up!";
                break;
            default:
                message = isCorrect ? "Nice work!" : "No. Keep trying..";
                break;
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public void inputAnswer() {
        for (int i = 0; i < questions.length; i++) {
            simulateQuestion(i);
        }
        final double percentageFactor = 100.0;
        double percentage = (double) score / questions.length
                * percentageFactor;
        JOptionPane.showMessageDialog(
                null,
                "You scored "
                        + String.format("%.2f", percentage)
                        + "%"
                        + " out of 100%");
    }
}
