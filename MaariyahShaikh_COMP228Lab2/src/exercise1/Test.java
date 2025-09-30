package exercise1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Test {
    JFrame f;
    Random randomObject = new Random();

    ArrayList<Question> questionList;
    int optionSelected = -1;

    // questions
    final String[] questions = {"1) Who is the professor of this course? \n",
            "2) How many significant digits does a floating-point number have? \n",
            "3) How many phases do Java programs have? \n",
            "4) What does an instance variable describe for an object? \n",
            "5) What does Java class promote? \n"};
    // answer options
    final String[] answers = {"A. Syed Yamin \nB. Ilia Nika \nC. James Gosling \nD. Steve Jobs \n",
            "A. 5 \nB. 7 \nC. 10 \nD. 15 \n",
            "A. 3 \nB. 4 \nC. 5 \nD. 6 \n",
            "A. Height \nB. Behaviour \nC. Measurement \nD. Properties \n",
            "A. Reusability \nB. Agility \nC. Readability \nD. Creativity \n"};

    // answer keys
    final int[] answerKeys = {0, 1, 2, 3, 0};

    // message for correct answer
    final String[] correctAnsMsg = {"Excellent!","Very good!","Keep up the good work!", "Nice work!"};

    // message for incorrect answer
    final String[] wrongAnsMsg = {"No. Please try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying"};

    // results
    int numberOfCorrect = 0;
    int numberOfWrong = 0;
    double percentageOfCorrect = 0.00d;

    public Test() {
        // load questions, answer options, answer keys to the array list when init
        questionList = new ArrayList<Question>();
        for (int i=0;  i<questions.length; i++) {
            questionList.add(new Question(questions[i], answers[i], answerKeys[i]));
        }
    }

    // simulate the questions
    public int simulateQuestion(int questionIndex) {
        // set value of the buttons for user to choose
        String[] options = {"A", "B", "C", "D"};

        // display questions and answers in JOptionPane
        f = new JFrame();
        int ansInput = JOptionPane.showOptionDialog(f,
                questionList.get(questionIndex).getPrompt() + "\n" +
                        questionList.get(questionIndex).getOptions() + "\n",
                "Select one: ",
                0, 3, null, options, options[0]);

        return ansInput;
    }

    // check the answer
    public boolean checkAnswer(int questionIndex, int optionSelected) {
        // count for correct answer
        if (questionList.get(questionIndex).getAnswerKey() == optionSelected) {
            numberOfCorrect++;
            percentageOfCorrect = (((double) numberOfCorrect / questionList.size()) * 100);
            return true;
        }
        // count for incorrect answer
        else {
            numberOfWrong++;
            percentageOfCorrect = (((double)numberOfCorrect / questionList.size()) * 100);
            return false;
        }
    }

    // display a random message for the user
    public void generateMessage(boolean isCorrect) {
        int msgIndex = 0;
        switch (randomObject.nextInt(4)) {
            case 0:
                msgIndex = 0;
                break;
            case 1:
                msgIndex = 1;
                break;
            case 2:
                msgIndex = 2;
                break;
            case 3:
                msgIndex = 3;
                break;
        }

        // display the random message of the corresponding type
        if (isCorrect)
            JOptionPane.showMessageDialog(f, getCorrectAnsMsg(msgIndex), "Congratulation!", 1);
        else
            JOptionPane.showMessageDialog(f, getWrongAnsMsg(msgIndex), "Oops...", 0);

    }

    // get message for correct answer
    public String getCorrectAnsMsg(int msgIndex) {
        return this.correctAnsMsg[msgIndex];
    }

    // get message for wrong answer
    public String getWrongAnsMsg(int msgIndex) {
        return this.wrongAnsMsg[msgIndex];
    }

    // interact with the user
    public void inputAnswer() {
        boolean isCorrect;

        // do the test
        for (int i=0;  i<questionList.size(); i++) {
            optionSelected = simulateQuestion(i);
            isCorrect = checkAnswer(i, optionSelected);
            generateMessage(isCorrect);
        }

        // show the result summary
        String resultSummary = "Total answered: " + (this.numberOfCorrect+this.numberOfWrong) + "\n\n" +
                "Number of Correct answers: " + this.numberOfCorrect + "\n" +
                "Number of Incorrect answers: " + this.numberOfWrong + "\n" +
                "Percentage of Correct answers: " + this.percentageOfCorrect + "%";
        JOptionPane.showMessageDialog(f, resultSummary);
    }
}