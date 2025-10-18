package exercise1;

abstract class Insurance {
    private String typeInsurance;
    private double monthlyCost;

    public Insurance(String typeInsurance) {
        this.typeInsurance = typeInsurance;
    }

    public String getTypeInsurance() {
        return typeInsurance;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public abstract void setInsuranceCost();
    public abstract void displayInfo();
}

