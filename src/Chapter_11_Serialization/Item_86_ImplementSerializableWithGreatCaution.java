package Chapter_11_Serialization;

// A major cost of implementing Serializable is that it decreases the flexibility to change
// a class’s implementation once it has been released.

// A second cost of implementing Serializable is that it increases the likelihood of bugs
// and security holes

// A third cost of implementing Serializable is that it increases the testing burden associated
// with releasing a new version of a class.

// Implementing Serializable is not a decision to be undertaken lightly.

// Classes designed for inheritance (Item 19) should rarely implement Serializable, and interfaces
// should rarely extend it.

/*
 * Best Practices for Implementing Serializable:
 * Minimize Usage:
 * <p>
 * Avoid implementing Serializable for new classes unless required for interoperability with legacy systems.
 * Use transient for Non-Serializable Fields:
 * <p>
 * Mark fields that should not be serialized, such as sensitive or temporary data, with the transient keyword.
 * Define serialVersionUID:
 * <p>
 * Explicitly define serialVersionUID to control the versioning of serialized forms and prevent InvalidClassException.
 * Implement readObject and writeObject Safely:
 * <p>
 * Validate input during deserialization to prevent attacks.
 * Ensure that deserialized objects are in a valid state.
 * Consider Serialization Proxies:
 * <p>
 * For complex classes, use the serialization proxy pattern, where a simpler proxy class represents the serialized form.
 * Avoid Inheriting Serializable:
 * <p>
 * Be cautious when extending a class that implements Serializable, as it forces the subclass to support serialization as well.
 */

import java.io.*;

class Person2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Object writeReplace() {
        return new PersonProxy(this);
    }

    private static class PersonProxy implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String name;
        private final int age;

        PersonProxy(Person2 person) {
            this.name = person.name;
            this.age = person.age;
        }

        private Object readResolve() {
            return new Person(name, age);
        }
    }
}

public class Item_86_ImplementSerializableWithGreatCaution {

}
