package Chapter_9_Exceptions;

/*
IllegalArgumentException         Non-null parameter value is inappropriate
IllegalStateException            Object state is inappropriate for method invocation
NullPointerException             Parameter value is null where prohibited
IndexOutOfBoundsException        Index parameter value is out of range
ConcurrentModificationException  Concurrent modification of an object has been detected where it is prohibited
UnsupportedOperationException    Object does not support method
 */
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


public class Item_72_FavorTheUseOfStandardExceptions {
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
    }

    //Example 2: When a Custom Exception Is Justified
    public void withdraw(double amount) throws InsufficientFundsException {
        double balance = 0;
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }
}
