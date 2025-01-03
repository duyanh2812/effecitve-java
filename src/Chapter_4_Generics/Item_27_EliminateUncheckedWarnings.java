package Chapter_4_Generics;

import java.util.ArrayList;
import java.util.List;

/*
In summary, unchecked warnings are important. Don’t ignore them. Every
unchecked warning represents the potential for a ClassCastException at
runtime. Do your best to eliminate these warnings. If you can’t eliminate an
unchecked warning and you can prove that the code that provoked it is typesafe,
suppress the warning with a @SuppressWarnings("unchecked")
annotation in the narrowest possible scope. Record the rationale for your
decision to suppress the warning in a comment.
 */
public class Item_27_EliminateUncheckedWarnings {
}

//Unchecked Warning (Bad Practice)
class UncheckedWarningExample {
    public static void main(String[] args) {
        List list = new ArrayList(); // Raw type
        list.add("String");
        list.add(123);

        List<String> stringList = list; // Unchecked cast
        for (String s : stringList) {   // ClassCastException at runtime
            System.out.println(s);
        }
    }
}

//Eliminating Unchecked Warnings
class SafeExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Parameterized type
        list.add("String");
        // list.add(123); // Compile-time error

        for (String s : list) {
            System.out.println(s);
        }
    }
}

//Suppressing Unchecked Warnings Responsibly
class SuppressUncheckedExample {
    @SuppressWarnings("unchecked")
    public static List<String> legacyMethod() {
        List rawList = new ArrayList(); // Legacy code
        rawList.add("String");
        return rawList; // Unchecked warning suppressed
    }

    public static void main(String[] args) {
        List<String> list = legacyMethod();
        for (String s : list) {
            System.out.println(s);
        }
    }
}