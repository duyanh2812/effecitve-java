package ClassesAndInterfaces;

/*
Key Points
What Are Static Member Classes?

A static member class is a nested class that is declared static.
It does not have an implicit reference to its enclosing instance.
It behaves like a top-level class but is logically grouped with its enclosing class.
What Are Nonstatic Member Classes?

A nonstatic member class is a nested class that is not declared static.
It has an implicit reference to the instance of the enclosing class.
It can access all instance members of the enclosing class, even private ones.
Why Favor Static Member Classes?

Avoid Memory Leaks: Nonstatic member classes retain a reference to the enclosing instance, which can prevent garbage collection.
Better Clarity: Static member classes are easier to reason about since they do not rely on the state of the enclosing instance.
Improved Modularity: Static member classes are more self-contained and can be used without requiring an instance of the enclosing class.
When to Use Nonstatic Member Classes?

Use them only when the class needs to access the enclosing instance's non-static fields or methods.
For example, inner classes that work closely with the enclosing class's instance state.

Disadvantages:

The InnerClass holds a reference to the OuterClass instance.
If InnerClass objects are used in a long-lived context while OuterClass is no longer needed, it can cause memory leaks.
 */
public class FavorStaticMemberClassesOverNonstatic {
}

//Static Member Class (Preferred)
/*
Advantages:
The StaticNestedClass does not require an instance of OuterClass.
It is independent and modular.
 */
class OuterClass {
    private static String staticField = "OuterClass Static Field";

    // Static member class
    public static class StaticNestedClass {
        public void display() {
            System.out.println("Accessing: " + staticField);
        }
    }

    public static void main(String[] args) {
        // Instantiating the static nested class
        StaticNestedClass nested = new StaticNestedClass();
        nested.display();
    }
}


//Nonstatic Member Class - SHOULDN'T
/*
Dis-advantages:
The InnerClass holds a reference to the OuterClass instance.
If InnerClass objects are used in a long-lived context while OuterClass is no longer needed, it can cause memory leaks.
 */
class OuterClass2 {
    private String instanceField = "OuterClass Instance Field";

    // Nonstatic member class
    public class InnerClass {
        public void display() {
            System.out.println("Accessing: " + instanceField);
        }
    }

    public static void main(String[] args) {
        OuterClass2 outer = new OuterClass2();
        InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}