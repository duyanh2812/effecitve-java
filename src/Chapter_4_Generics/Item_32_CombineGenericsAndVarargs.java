package Chapter_4_Generics;

import java.util.HashSet;
import java.util.Set;

/*
Use @SafeVarargs for Truly Safe Methods:

Ensure the method does not expose or store the varargs array.
Encapsulate Unsafe Operations:

Use private helper methods to isolate potentially unsafe operations.
Prefer Collections Over Varargs:

When designing APIs, use List or Set instead of varargs for better type safety.
Avoid Mixing Generics and Varargs in Fields:

Do not store varargs arrays in fields or pass them around unsafely.
 */
public class Item_32_CombineGenericsAndVarargs {

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        Set<Integer> s2 = new HashSet<>();
        s2.add(2);
        s2.add(3);
        Set<Integer> s3 = union(s1, s2);
        System.out.println(s3);
    }

    @SafeVarargs
    static <T> Set<T> union(Set<T>... sets) {
        Set<T> result = new HashSet<>();
        for (Set<T> set : sets) {
            result.addAll(set);
        }
        return result;
    }
}
