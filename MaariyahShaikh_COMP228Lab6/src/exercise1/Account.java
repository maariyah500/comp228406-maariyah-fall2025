package exercise1;

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(String threadName, double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("%s withdrew %.2f. New balance: %.2f%n", threadName, amount, balance);
        } else {
            System.out.printf("%s tried to withdraw %.2f but not enough balance. Current balance: %.2f%n", threadName, amount, balance);
        }
    }

    public synchronized void deposit(String threadName, double amount) {
        balance += amount;
        System.out.printf("%s deposited %.2f. New balance: %.2f%n", threadName, amount, balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}
