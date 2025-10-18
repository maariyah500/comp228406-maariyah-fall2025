package exercise2;

import java.util.Scanner;

class GameTesterApp {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter game tester type (FullTime/PartTime):");
        String type = scanner.nextLine();

        System.out.println("Enter game tester name:");
        String name = scanner.nextLine();

        GameTester tester;
        if (type.equalsIgnoreCase("FullTime")) {
            tester = new FullTimeGameTester(name);
        } else if (type.equalsIgnoreCase("PartTime")) {
            System.out.println("Enter number of hours worked:");
            int hours = scanner.nextInt();
            tester = new PartTimeGameTester(name, hours);
        } else {
            System.out.println("Invalid game tester type.");
            scanner.close();
            return;
        }

        System.out.println("\nGame Tester Information:");
        System.out.println("Name: " + tester.getName());
        System.out.println("Status: " + (tester.isFullTime() ? "Full-time" : "Part-time"));
        System.out.println("Salary: $" + tester.calculateSalary());

        scanner.close();
    }
}
