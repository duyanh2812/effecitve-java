package Chapter_6_LambdasAndStreams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Why Prefer Side-Effect-Free Functions?
Predictability:

Side-effect-free functions are deterministic, meaning they will always produce the same output for the same input, making your code more predictable.
Since they don’t modify any external state, you don’t need to worry about unintended changes or bugs caused by shared mutable state.
Concurrency and Parallelism:

In parallel streams, side effects can cause issues, as multiple threads may attempt to modify the same state concurrently. This can lead to race conditions and non-deterministic behavior.
Side-effect-free functions are inherently thread-safe, which is particularly important when using parallel streams.
Composability:

Side-effect-free functions are easier to compose. They can be chained together in a stream pipeline without worrying about one function affecting the result of another.
This leads to cleaner, more modular code where each transformation is isolated and easier to test.
Debugging:

Since side-effect-free functions don’t change external state, debugging becomes easier. You can focus on understanding the input-output relationship without worrying about hidden side effects.
 */
public class Item_46_PreferSideEffectFreeFunctionsInStreams {
    public static void main(String[] args) {
        // Stream with side effect - DO NOT DO THIS!!
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Set<String> processedWords = new HashSet<>();

        words.parallelStream()
                .forEach(word -> processedWords.add(word.toUpperCase())); // Side effect: modifying external state
        System.out.println(processedWords); // Output may vary due to race conditions

        // Stream with no side effect
        List<String> words2 = Arrays.asList("apple", "banana", "cherry");
        // Avoid modifying external state in forEach
        words2.forEach(word -> System.out.println(word.toUpperCase())); // No side effect on external state
    }
}
