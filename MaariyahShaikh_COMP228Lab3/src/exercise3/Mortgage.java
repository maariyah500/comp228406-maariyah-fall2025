package exercise3;

import java.text.DecimalFormat;

abstract class Mortgage implements MortgageConstants {
    private int mortgageNumber;
    private String customerName;
    private double mortgageAmount;
    protected double interestRate;
    private int term;

    public Mortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;

        if (mortgageAmount > maxMortgageAmount) {
            this.mortgageAmount = maxMortgageAmount;
            System.out.println("Mortgage amount exceeds maximum. Amount set to " + maxMortgageAmount);
        } else {
            this.mortgageAmount = mortgageAmount;
        }

        if (term == shortTerm || term == mediumTerm || term == longTerm) {
            this.term = term;
        } else {
            this.term = shortTerm;
            System.out.println("Invalid term. Term set to short-term (1 year).");
        }
    }

    public abstract void setInterestRate(double primeRate);

    public double calculateTotalAmountOwed() {
        return mortgageAmount * (1 + interestRate * term);
    }

    public void getMortgageInfo() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("\n--- Mortgage Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Mortgage Number: " + mortgageNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Mortgage Amount: $" + df.format(mortgageAmount));
        System.out.println("Interest Rate: " + df.format(interestRate * 100) + "%");
        System.out.println("Term (years): " + term);
        System.out.println("Total Amount Owed: $" + df.format(calculateTotalAmountOwed()));
    }
}