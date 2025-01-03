package Chapter_7_Methods;

import java.util.ArrayList;
import java.util.List;

/*
Defensive copying is the practice of creating a copy of an object when it is passed
to or returned from a method, instead of directly exposing the original object. This
ensures that the original object remains unchanged, even if the copy is modified by
the caller.
 */
public class Item_50_MakeDefensiveCopiesWhenNeeded {
}

/*
1. When you receive a mutable object as a parameter, make a copy of it to ensure that
 the caller cannot modify it. This is especially important when the object is passed
  to methods that may alter its state.
 */
class Employee {
    private final List<String> skills;

    public Employee(List<String> skills) {
        // Make a defensive copy of the list to prevent external modification
        this.skills = new ArrayList<>(skills);
    }

    public List<String> getSkills() {
        // Return a defensive copy to prevent external modification
        return new ArrayList<>(skills);
    }
}

/*
When returning a mutable object from a method, make a defensive copy to prevent
the caller from modifying the original object. This is crucial when the object
is part of the internal state of the class.
 */

class Transaction {

}

class BankAccount {
    private final List<Transaction> transactions;

    public BankAccount(List<Transaction> transactions) {
        this.transactions = new ArrayList<>(transactions);
    }

    public List<Transaction> getTransactions() {
        // Return a defensive copy to prevent external modification
        return new ArrayList<>(transactions);
    }
}

// Arrays are mutable in Java, so defensive copying is essential when you pass or return arrays.
class Inventory {
    private final String[] items;

    public Inventory(String[] items) {
        // Make a defensive copy of the array to prevent external modification
        this.items = items.clone();
    }

    public String[] getItems() {
        // Return a defensive copy of the array
        return items.clone();
    }
}

/*
When Not to Make Defensive Copies
1. When the Object is Immutable:
2. When Performance is Critical:
3. When the Object is Not Shared:
 */
class Book {
    
}

class Library {
    private final List<Book> books;

    public Library(List<Book> books) {
        // Defensive copy to protect the internal list from external modification
        this.books = new ArrayList<>(books);
    }

    public List<Book> getBooks() {
        // Return a defensive copy of the books list to prevent modification
        return new ArrayList<>(books);
    }
}