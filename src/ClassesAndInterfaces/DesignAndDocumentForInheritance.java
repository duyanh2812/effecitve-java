package ClassesAndInterfaces;

/*
In summary, designing a class for inheritance is hard work. You must
document all of its self-use patterns, and once you’ve documented them, you
must commit to them for the life of the class. If you fail to do this, subclasses
may become dependent on implementation details of the superclass and may
break if the implementation of the superclass changes. To allow others to write
efficient subclasses, you may also have to export one or more protected methods.
Unless you know there is a real need for subclasses, you are probably better off
prohibiting inheritance by declaring your class final or ensuring that there are no
accessible constructors

Design for Inheritance

When allowing inheritance, ensure the class is explicitly designed to be extended.
Provide clear documentation on how subclasses should interact with the superclass.
Avoid calling overridable methods from constructors.
Use the Template Method design pattern to allow controlled extension points.
Prohibit Inheritance

If a class is not designed for inheritance, declare it as final.
Alternatively, make the constructors private or package-private and provide static factory methods for object creation.
Why Prohibit Inheritance by Default?

Inheritance exposes internal implementation details, making it harder to evolve the class.
Subclasses might break the superclass’s invariants or violate encapsulation.


 */
public class DesignAndDocumentForInheritance {
}

class NonInheritableClass {
    private NonInheritableClass() {
        // Prevent instantiation
    }

    public static NonInheritableClass createInstance() {
        return new NonInheritableClass();
    }
}

final class UtilityClass {
    private UtilityClass() {
        // Prevent instantiation
    }

    public static void utilityMethod() {
        System.out.println("This is a utility method.");
    }
}

abstract class AbstractShape {
    // Template method pattern
    public final void draw() {
        System.out.println("Preparing to draw...");
        doDraw();
        System.out.println("Finished drawing.");
    }

    // Extension point for subclasses
    protected abstract void doDraw();
}

class Circle extends AbstractShape {
    @Override
    protected void doDraw() {
        System.out.println("Drawing a circle.");
    }
}

class Square extends AbstractShape {
    @Override
    protected void doDraw() {
        System.out.println("Drawing a square.");
    }
}

