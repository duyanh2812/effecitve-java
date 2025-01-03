package Chapter_7_Methods;

import java.time.LocalDate;

/*
Why Check Parameters for Validity?
Prevent Invalid State:

Validating parameters helps ensure that the method is not operating on invalid data, which could lead to incorrect behavior or exceptions later in the program.
Improve Debugging:

By checking parameters early, you can catch invalid inputs at the point where the method is invoked, making it easier to debug and understand where the problem occurred.
Increase Code Robustness:

Validating inputs prevents the propagation of invalid data through the system, which can result in harder-to-find bugs and unexpected behavior.
Clear Contracts for Methods:

Parameter validation provides a clear contract for your methods: it explicitly defines what values are acceptable and what are not. This makes the method's behavior more predictable and helps developers understand how to use the method correctly.
 */
public class Item_49_CheckParametersForValidity {
    String name;
    String email;
    int age;
    String username;
    String item;

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public void setUsername(String username) {
        if (username == null || username.length() < 5 || username.length() > 15) {
            throw new IllegalArgumentException("Username must be between 5 and 15 characters");
        }
        this.username = username;
    }

    public void setItem(Object item) {
        if (!(item instanceof String)) {
            throw new IllegalArgumentException("Item must be a String");
        }
        this.item = (String) item;
    }

    public void setDateRange(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start and end dates cannot be null");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before or equal to end date");
        }
    }
}
