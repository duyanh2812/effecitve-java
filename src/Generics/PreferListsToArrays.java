package Generics;

import java.util.ArrayList;
import java.util.List;

/*
Key Points
Arrays vs. Lists

Arrays are a low-level construct with a fixed size and do not support generics.
Lists are part of the Java Collections Framework, dynamic in size, and fully support generics.
Type Safety

Arrays are covariant: String[] is a subtype of Object[]. This can lead to runtime errors.
Lists are invariant: List<String> is not a subtype of List<Object>, preventing unsafe operations at compile time.
Generics Integration

Arrays do not mix well with generics, as you cannot create generic arrays.
Lists integrate seamlessly with generics, providing type safety and flexibility.
Flexibility

Lists can grow and shrink dynamically, whereas arrays have a fixed size.
Lists provide a richer set of operations, such as add, remove, and contains.


 */
public class PreferListsToArrays {
}
//Problem with Arrays (Covariance)
class ArrayCovariance {
    public static void main(String[] args) {
        Object[] objectArray = new String[2];
        objectArray[0] = "String";
        objectArray[1] = 123; // Throws ArrayStoreException at runtime
    }
}
// Lists Prevent Type Errors

class ListExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        // stringList.add(123); // Compile-time error
    }
}

//Arrays Do Not Work Well with Generics
class GenericArrayExample<T> {
    // Illegal: Cannot create a generic array
    // T[] array = new T[10];
}

// Using Lists with Generics
class GenericListExample<T> {
    private List<T> list = new ArrayList<>();

    public void addElement(T element) {
        list.add(element);
    }

    public T getElement(int index) {
        return list.get(index);
    }
}
/*
When to Use Arrays
Despite their limitations, arrays are appropriate in certain scenarios:

Performance-Critical Code: Arrays can be faster for primitive types or when low-level control is required.
Interfacing with Legacy Code: Some APIs require arrays as input or output.
Fixed-Size Data Structures: Arrays are suitable when the size is known and unchanging.
 */