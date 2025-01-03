package Chapter_4_Generics;

import java.util.ArrayList;
import java.util.List;

/*
In summary, generic types are safer and easier to use than types that require
casts in client code. When you design new types, make sure that they can be
used without such casts. This will often mean making the types generic.
If youhave any existing types that should be generic but aren’t, generify them. This
will make life easier for new users of these types without breaking existing
client

What Are Generics?

Generics allow you to define classes, interfaces, and methods with type parameters, making your code more flexible and type-safe.
Instead of using raw types (e.g., Object), generics allow you to specify the type of elements in collections or other data structures (e.g., List<String>).
Advantages of Generics

Type Safety: Generics enforce type constraints at compile time, preventing ClassCastException and other runtime errors.
Code Reusability: Generics allow you to write code that works with any type, making it more reusable across different contexts.
Eliminates Casting: With generics, you don’t need to cast objects when retrieving them from collections, reducing boilerplate code and potential errors.
Avoiding Raw Types

Raw types (e.g., List instead of List<String>) can lead to type safety issues and require casting, which can introduce errors.
Generics eliminate the need for raw types and provide more specific type information, making your code safer and easier to maintain.

 */
public class Item_29_FavorGenericTypes {
}

// Using Raw Types (Bad Practice)
class RawTypeExample2 {
    public static void main(String[] args) {
        List rawList = new ArrayList(); // Raw type
        rawList.add("Hello");
        rawList.add(123); // Allowed, but dangerous

        String str = (String) rawList.get(0); // No compile-time type checking
        Integer num = (Integer) rawList.get(1); // ClassCastException at runtime
    }
}

//Using Generics (Preferred)
class GenericExample2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(); // Generic type
        stringList.add("Hello");
        // stringList.add(123); // Compile-time error

        String str = stringList.get(0); // No need for casting
        System.out.println(str);
    }
}

//Generic Methods
class GenericMethodExample {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"Hello", "World"};

        printArray(intArray); // No need for casting
        printArray(strArray); // No need for casting
    }
}

/*
Best Practices
Use Generics in Collections:

Always use generics in collections (e.g., List<String>, Map<String, Integer>) to ensure type safety and avoid casting.
Avoid Raw Types:

Never use raw types when you can use generics. If you must use raw types, ensure you understand the trade-offs and document your reasoning.
Use Bounded Wildcards When Necessary:

Use bounded wildcards (e.g., List<? extends Number>) when you need to allow flexibility in the types but still maintain some type constraints.
Use Generics for Method Parameters:

Define generic methods to make your code more reusable and type-safe.
 */