package exercise3;

import javax.swing.JOptionPane;

public class OverloadTest {

    public static void main(String[] args) {
        OverloadMethods object=new OverloadMethods();
        int number1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the first number:"));
        int number2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the second number:"));
        int number3 = Integer.parseInt(JOptionPane.showInputDialog("Enter the third number:"));
        object.sum(number1);//using 1 argument
        object.sum(number1,number2);//using 2 argument
        object.sum(number1,number2,number3);//using 3 argument
    }

}