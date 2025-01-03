package Chapter_3_ClassesAndInterfaces;

public class Item_23_PreferClassHierarchiesToTaggedClasses {
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

