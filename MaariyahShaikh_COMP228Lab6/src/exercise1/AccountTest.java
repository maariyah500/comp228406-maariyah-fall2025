package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountTest {
    static void main(String[] args) {
        Account sharedAccount = new Account(1000.0);

        ArrayList<Runnable> transactions = new ArrayList<>();
        transactions.add(new Transaction(sharedAccount, "Transaction 1", 200.0, 150.0));
        transactions.add(new Transaction(sharedAccount, "Transaction 2", 300.0, 250.0));
        transactions.add(new Transaction(sharedAccount, "Transaction 3", 500.0, 100.0));
        transactions.add(new Transaction(sharedAccount, "Transaction 4", 100.0, 50.0));

        ExecutorService executorService = Executors.newFixedThreadPool(transactions.size());

        System.out.println("--- Starting ATM Transactions ---");

        for (Runnable transaction : transactions) {
            executorService.execute(transaction);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("ExecutorService interrupted during shutdown.");
        }

        System.out.println("--- All ATM Transactions Complete ---");
        System.out.printf("Final account balance: %.2f%n", sharedAccount.getBalance());
    }
}

