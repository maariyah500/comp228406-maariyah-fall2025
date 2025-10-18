package exercise3;

class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
    }

    @Override
    public void setInterestRate(double primeRate) {
        this.interestRate = primeRate + 0.01; // 1% over prime rate
    }
}
