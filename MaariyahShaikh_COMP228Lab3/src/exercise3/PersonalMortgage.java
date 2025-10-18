package exercise3;

class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double mortgageAmount, int term) {
        super(mortgageNumber, customerName, mortgageAmount, term);
    }

    @Override
    public void setInterestRate(double primeRate) {
        this.interestRate = primeRate + 0.02; // 2% over prime rate
    }
}