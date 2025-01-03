package Chapter_9_Exceptions;

import java.util.ArrayList;
import java.util.List;

/*
 * Strategies to Achieve Failure Atomicity:
 * <p>
 * Immutable Objects:
 * Operations on immutable objects inherently provide failure atomicity because they do not modify the object but instead create a new one.
 * Check for Failures Early:
 * Validate arguments and preconditions before performing operations.
 * Order of Operations:
 * Perform operations in a way that intermediate states are consistent.
 * Temporary Copies:
 * Work on a temporary copy of the object and replace the original only after the operation succeeds.
 * Rollback Mechanisms:
 * Use mechanisms like transactions or exception handling to undo partial changes when an operation fails.
 * Defensive Copies:
 * Make a defensive copy of mutable inputs and work on the copy to prevent external interference.
 */
public class Item_76_StriveForFailureAtomicity {
    // Example 1: Temporary Copy
    public void updateList(List<String> list, String newValue) {
        List<String> temp = new ArrayList<>(list);
        temp.add(newValue); // Perform operation on a temporary copy
        list.clear();
        list.addAll(temp); // Replace original only after success
    }

    //Example 2: Using Transactions:
    // In database operations, ensure all changes are within a transaction so that any failure can roll back the operation.

    public void transfer(Account from, Account to, double amount) {
        // Check for valid input to prevent exceptions
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        // Perform operations in a failure-atomic way
        synchronized (from) {
            synchronized (to) {
                if (from.getBalance() < amount) {
                    throw new IllegalStateException("Insufficient funds");
                }
                // Perform transfer
                from.debit(amount);
                try {
                    to.credit(amount); // Ensure this operation is safe
                } catch (Exception e) {
                    // Rollback in case of failure
                    from.credit(amount); // Restore original state
                    throw new RuntimeException("Transfer failed. Rolled back.", e);
                }
            }
        }
    }

}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void debit(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public synchronized void credit(double amount) {
        balance += amount;
    }
}
