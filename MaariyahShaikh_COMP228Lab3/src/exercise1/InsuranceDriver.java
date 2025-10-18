package exercise1;

import java.util.Scanner;

class InsuranceDriver {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance[] policies = new Insurance[3];
        int count = 0;

        while (true) {
            System.out.println("\nEnter insurance type (Health/Life) or 'quit' to exit:");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("quit")) {
                break;
            }

            if (count >= policies.length) {
                System.out.println("Array is full. Cannot add more policies.");
                break;
            }

            System.out.println("Enter monthly cost:");
            double cost = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            Insurance insurance;
            if (type.equalsIgnoreCase("Health")) {
                insurance = new Health();
            } else if (type.equalsIgnoreCase("Life")) {
                insurance = new Life();
            } else {
                System.out.println("Invalid insurance type.");
                continue;
            }

            insurance.setMonthlyCost(cost);
            insurance.setInsuranceCost();
            policies[count] = insurance;
            count++;
        }

        System.out.println("\n--- Insurance Policy Information ---");
        for (int i = 0; i < count; i++) {
            policies[i].displayInfo();
            System.out.println("--------------------");
        }
        scanner.close();
    }
}

