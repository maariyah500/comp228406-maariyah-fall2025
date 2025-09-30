package exercise3;

import javax.swing.*;
import java.math.BigDecimal;

// Ex. 3
public class Main {
    static String input1 = "";
    static String input2 = "";
    static String result = "";

    // Tester of overloaded static methods
    public static void main(String[] args) {
        System.out.println("Ex. 3");
        System.out.println("=====================");

        // read input from user
        input1 = JOptionPane.showInputDialog(null,
                "Input 1st number", null,3);

        input2 = JOptionPane.showInputDialog(null,
                "Input 2nd number", null,3);

        // 1. call add() with arguments in Double datatype
        result = String.format("%.8f",
                add(Double.parseDouble(input1), Double.parseDouble(input2)));
        JOptionPane.showMessageDialog(null,
                ("Result of " + input1 + " + " + input2 + " = " + result),
                "Overloading add() for Double", 1);

        // 2. call add() with arguments in Integer datatype
        result = Integer.toString(
                add((int)Math.round(Double.parseDouble(input1)), (int)Math.round(Double.parseDouble(input2))));
        JOptionPane.showMessageDialog(null,
                ("Result of " + input1 + " + " + input2 + " = " + result),
                "Overloading add() for Integer", 1);

        // 3. call add() with arguments in String datatype
        result = add(input1, input2);
        JOptionPane.showMessageDialog(null,
                ("Result of " + input1 + " + " + input2 + " = " + result),
                "Overloading add() for String", 1);

    }

    // add() with arguments in decimal values
    public static double add(Double firstValue, Double secondValue) {
        return firstValue + secondValue;
    }

    // add() with arguments in integer values
    public static Integer add(Integer firstValue, Integer secondValue) {
        return firstValue + secondValue;
    }

    // add() with arguments in string
    public static String add(String firstValue, String secondValue) {
        // parse input value from String to Double
        Double firstNumeric = Double.parseDouble(firstValue);
        Double secondNumeric = Double.parseDouble(secondValue);
        // parse result from Double to String
        return String.format("%.4f", Double.sum(firstNumeric, secondNumeric));
    }
}