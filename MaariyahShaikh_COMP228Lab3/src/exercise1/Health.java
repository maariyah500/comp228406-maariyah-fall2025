package exercise1;

class Health extends Insurance {
    public Health() {
        super("Health");
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
