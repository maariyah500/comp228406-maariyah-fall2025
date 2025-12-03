package exercise1;

class Transaction implements Runnable {
    private Account account;
    private String transactionName;
    private double withdrawAmount;
    private double depositAmount;

    public Transaction(Account account, String transactionName, double withdrawAmount, double depositAmount) {
        this.account = account;
        this.transactionName = transactionName;
        this.withdrawAmount = withdrawAmount;
        this.depositAmount = depositAmount;
    }

    @Override
    public void run() {
        System.out.printf("%s starting. Initial balance: %.2f%n", transactionName, account.getBalance());

        account.withdraw(transactionName, withdrawAmount);

        account.deposit(transactionName, depositAmount);

        System.out.printf("%s finished. Final balance: %.2f%n", transactionName, account.getBalance());
    }
}