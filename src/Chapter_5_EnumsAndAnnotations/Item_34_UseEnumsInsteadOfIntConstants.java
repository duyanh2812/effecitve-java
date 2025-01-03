package Chapter_5_EnumsAndAnnotations;

import java.util.EnumSet;

/*
Use Enums Instead of int Constants:

Enums are type-safe, self-documenting, and extensible.
Add Behavior to Enums When Needed:

Use fields, methods, and constructors to encapsulate related data and behavior.
Leverage Enum-Specific Utilities:

Use EnumSet and EnumMap for collections and maps involving enums.
By using enums instead of int constants, you can create more robust, maintainable, and expressive code.
 */
public class Item_34_UseEnumsInsteadOfIntConstants {
    public static void main(String[] args) {
        double x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        for (Planet planet : Planet.values()) {
            System.out.println(STR."\{planet} + \{planet.surfaceGravity()}");
        }

        EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
    }

    public static String getDayType(Day day) {
        return switch (day) {
            case SATURDAY, SUNDAY -> "Weekend";
            default -> "Weekday";
        };
    }
}

enum Planet {
    MERCURY(3.30e+23, 2.4397e6),
    VENUS(4.87e+24, 6.0518e6),
    EARTH(5.97e+24, 6.3781e6);

    private final double mass;    // In kilograms
    private final double radius; // In meters

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        final double G = 6.67430e-11; // Gravitational constant
        return G * mass / (radius * radius);
    }
}

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

enum Operation {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        public double apply(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}