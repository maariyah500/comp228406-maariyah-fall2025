package exercise2;

class FullTimeGameTester extends GameTester {
    private static final double baseSalary = 3000.0;

    public FullTimeGameTester(String name) {
        super(name, true);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}
