package exercise3;

import javax.swing.JOptionPane;

public class OverloadMethods {

    int sum;
    public  void sum(int number2)
    {
        sum = number2;
        JOptionPane.showMessageDialog(null,sum);
    }
    public  void sum(int number2,int number3)
    {
        sum = number2+number3;

        JOptionPane.showMessageDialog(null,sum);
    }
    public  void sum(int number2,int number3,int number4)
    {
        sum = number2+number3+number4;

        JOptionPane.showMessageDialog(null,sum);
    }
    public OverloadMethods()
    { }

    }