package Chapter_8_GeneralProgramming;

import java.util.Arrays;
import java.util.List;

/*
Primitive types are stored directly in memory, making them faster and more memory-efficient.
Boxed primitives are objects, requiring additional memory for object headers and
causing extra overhead for boxing and unboxing.

Boxed Primitives Can Cause Unexpected Behavior:

NullPointerException: Boxed primitives can be null, leading to runtime exceptions.
Equality Pitfalls: == compares object references for boxed primitives, not values.

Boxing and Unboxing Overhead:

Converting between primitives and their boxed counterparts (auto-boxing and unboxing)
adds performance overhead.
 */

/*
Use Primitives by Default:

Prefer int over Integer, double over Double, etc., unless there is a specific need for the boxed type.
Avoid Mixing Primitives and Boxed Primitives:

Mixing types can lead to unexpected behavior due to auto-boxing and unboxing.
Be Mindful of Collections and Generics:

Use boxed primitives when working with collections or generic types.
Leverage Primitive Streams for Performance:

Use IntStream, DoubleStream, and LongStream for primitive operations in Java Streams.
 */
public class Item_61_PreferPrimitiveTypesToBoxedPrimitives {
    public static void main(String[] args) {
        Integer count = null;
        int total = count + 1; // Throws NullPointerException (unboxing null)

        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }

// Using boxed primitives
        Integer sum2 = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum2 += i; // Auto-boxing and unboxing in every iteration
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3); // Must use boxed primitives

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); // false (different objects)
    }

    // Hideously slow program! Can you spot the object creation?
    public void calculate(String[] args) {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
