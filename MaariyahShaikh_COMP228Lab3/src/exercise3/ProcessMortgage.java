package exercise3;

import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];

        System.out.print("Enter the current prime interest rate (e.g., 0.03 for 3%): ");
        double primeRate = input.nextDouble();

        for (int i = 0; i < mortgages.length; i++) {
            System.out.println("\nEnter details for Mortgage #" + (i + 1));
            System.out.print("Enter mortgage type (1 for Personal, 2 for Business): ");
            int type = input.nextInt();
            input.nextLine();

            System.out.print("Enter customer name: ");
            String customerName = input.nextLine();

            System.out.print("Enter mortgage amount: ");
            double amount = input.nextDouble();

            System.out.print("Enter mortgage term (1, 3, or 5 years): ");
            int term = input.nextInt();
            input.nextLine();

            if (type == 1) {
                mortgages[i] = new PersonalMortgage(i + 1, customerName, amount, term);
            } else if (type == 2) {
                mortgages[i] = new BusinessMortgage(i + 1, customerName, amount, term);
            } else {
                System.out.println("Invalid mortgage type. Defaulting to Personal Mortgage.");
                mortgages[i] = new PersonalMortgage(i + 1, customerName, amount, term);
            }
            mortgages[i].setInterestRate(primeRate);
        }

        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
        }

        input.close();
    }
}