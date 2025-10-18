package exercise1;

class Life extends Insurance {
    public Life() {
        super("Life");
    }

    @Override
    public void setInsuranceCost() {
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getTypeInsurance());
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }
}
