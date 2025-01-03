package Chapter_3_ClassesAndInterfaces;

/*
To summarize, an interface is generally the best way to define a type that
permits multiple implementations. If you export a nontrivial interface, you
should strongly consider providing a skeletal implementation to go with it. To
the extent possible, you should provide the skeletal implementation via default
methods on the interface so that all implementors of the interface can make use
of it. That said, restrictions on interfaces typically mandate that a skeletal
implementation take the form of an abstract class

Why Prefer Interfaces?

Multiple Inheritance: A class can implement multiple interfaces, but it can only extend one abstract class.
Flexibility: Interfaces allow for a cleaner separation of behavior and implementation.
Mixins: Interfaces enable the creation of mixins (small reusable units of functionality) without requiring a rigid inheritance hierarchy.
Default Methods: Starting with Java 8, interfaces can include default methods, enabling them to provide reusable functionality while maintaining backward compatibility.
When to Use Abstract Classes?

Abstract classes are suitable when you need to share state or implementation among closely related classes.
They are useful when the base class has fields or methods that subclasses should inherit directly.
Drawbacks of Abstract Classes

Lack of multiple inheritance makes them less versatile for combining behaviors.
Tight coupling between the abstract class and its subclasses can lead to less flexible designs.

 */
public class Item_20_PreferInterfacesToAbstractClasses {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();

        Animal cat = new Cat();
        cat.eat();
        cat.sleep();
    }
}

interface Animal {
    void eat();

    default void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }
}
