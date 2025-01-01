package ClassesAndInterfaces;

import java.util.regex.Pattern;/*
What Are Tagged Classes?

A tagged class uses a field to indicate its "type," and its behavior depends on the value of that field.
Example: A class with a type field that can have values like CIRCLE or RECTANGLE, with conditional logic (if or switch) for each type.
Problems with Tagged Classes

Verbose and Error-Prone: Requires repetitive if or switch statements to handle each type.
Hard to Maintain: Adding a new type requires changes in multiple places.
Breaks Encapsulation: Exposes internal implementation details (e.g., the type field).
Poor Use of Polymorphism: Does not leverage the object-oriented design principles.
Advantages of Class Hierarchies

Cleaner Code: Behavior is encapsulated in subclasses.
Easier Maintenance: Adding a new type involves creating a new subclass without modifying existing code.
Polymorphism: Eliminates the need for conditional logic based on type.

 */
public class PreferClassHierarchiesToTaggedClasses {
}

// Tagged Class Example (Anti-Pattern) - DO NOT USE!
class FigureAnti {
    enum Shape { CIRCLE, RECTANGLE }

    private final Shape shape;

    // Fields for circle
    private double radius;

    // Fields for rectangle
    private double length;
    private double width;

    // Constructor for circle
    public FigureAnti(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    public FigureAnti(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    public double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI * radius * radius;
            case RECTANGLE:
                return length * width;
            default:
                throw new AssertionError("Unknown shape: " + shape);
        }
    }
}
// Class Hierarchy Example (Preferred)
abstract class Figure {
    public abstract double area();
}

class Circle1 extends Figure {
    private final double radius;

    public Circle1(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Figure {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

