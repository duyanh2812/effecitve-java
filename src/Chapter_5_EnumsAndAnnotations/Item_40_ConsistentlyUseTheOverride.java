package Chapter_5_EnumsAndAnnotations;

/*
Always Use @Override:

When overriding methods from a superclass.
When implementing methods from an interface (Java 1.6+).
Leverage Compiler Checks:

Let the compiler catch mistakes such as typos or incorrect method signatures.
Maintain Consistency:

Consistent use of @Override improves code readability and reduces the risk of errors.
By consistently using the @Override annotation, you can write safer, clearer, and more maintainable Java code.
 */
public class Item_40_ConsistentlyUseTheOverride {
}

class Parent {
    public void display(int value) {
    }
}

class Child extends Parent {
    //    @Override
    public void display() {
    } // Compile-time error

    //    @Override
    public void display(String value) {
    }

    @Override
    public String toString() {
        return "Custom toString implementation";
    }
}
