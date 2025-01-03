package Chapter_5_EnumsAndAnnotations;

/*
What Are Marker Interfaces?

A marker interface is an interface with no methods or fields. It is used to "mark" a class as having a specific property or behavior.
Example: java.io.Serializable is a marker interface that indicates a class can be serialized.
How Marker Interfaces Work

Marker interfaces rely on the type system to enforce behavior.
They allow you to group and identify classes that share a specific property.
Advantages of Marker Interfaces

Type Safety: Marker interfaces are part of the type system, allowing compile-time checks.
Code Clarity: They explicitly convey that a class is part of a specific type or category.
Selective Applicability: You can limit where a marker interface is applied by restricting its use to certain class hierarchies.
Comparison with Marker Annotations

Marker Interfaces:
Provide type information that can be used in method signatures.
Work at compile time and integrate with the type system.
Marker Annotations:
Provide metadata for runtime processing.
Do not affect the type system.
 */
public class Item_41_UseMarkerInterfacesToDefineTypes {
    public static void main(String[] args) {
        AuditProcessor auditProcessor = new AuditProcessor();
        auditProcessor.process(new User("Duy Anh"));
        auditProcessor.process(new Object());
    }
}

interface Auditable {
}

class User implements Auditable {
    String name;

    // Constructor, getters, and setters
    public User(String name) {
        this.name = name;
    }


}

class AuditProcessor {
    public void process(Object obj) {
        if (obj instanceof Auditable) {
            System.out.println("Auditing: " + obj);
        } else {
            System.out.println("Object is not auditable");
        }
    }
}