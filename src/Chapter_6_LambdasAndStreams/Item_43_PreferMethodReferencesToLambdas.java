package Chapter_6_LambdasAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/*
Use Method References for Simplicity:

Prefer them when the lambda is just a call to an existing method.
Fallback to Lambdas for Complex Logic:

Use lambdas when additional logic is needed that cannot be expressed with a method reference.
Aim for Readability:

Prioritize code clarity. If a method reference is unclear, use a lambda.
By preferring method references to lambdas in simple cases, you can make your code more concise, readable, and expressive.
 */
public class Item_43_PreferMethodReferencesToLambdas {
    public static void main(String[] args) {
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> list = Arrays.asList("a", "b", "c");
//        list.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        list.sort(String::compareToIgnoreCase);

        List<String> list2 = Arrays.asList("a", "b", "c");
//        list2.forEach(s -> System.out.println(s));
        list2.forEach(System.out::println);
    }
}
