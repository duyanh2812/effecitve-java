package Generics;

import java.util.ArrayList;
import java.util.List;

/*
In summary, using raw types can lead to exceptions at runtime, so don’t use
them.
 */
public class DontUseRawType {
}

//Using Raw Types (Bad Practice)
class RawTypeExample {
    public static void main(String[] args) {
        List list = new ArrayList(); // Raw type
        list.add("String");
        list.add(123); // Allowed, but dangerous

        for (Object obj : list) {
            String str = (String) obj; // ClassCastException at runtime
            System.out.println(str);
        }
    }
}

//Using Generics (Preferred)
class GenericExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Generic type
        list.add("String");
        // list.add(123); // Compilation error

        for (String str : list) {
            System.out.println(str); // No need for casting
        }
    }
}
/*
Always Specify Type Parameters: Use generics to ensure type safety.
Use Wildcards for Unknown Types: Replace raw types with wildcard types like List<?>.
Avoid Mixing Raw and Generic Types: Mixing them can lead to unchecked warnings and potential runtime issues.
Refactor Legacy Code: Gradually replace raw types with generics when maintaining older code.
 */