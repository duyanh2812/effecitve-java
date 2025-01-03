package Chapter_6_LambdasAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Use Streams for Complex Data Transformations:
Streams are ideal for filtering, mapping, and reducing data in a functional, declarative style.
Avoid Streams for Simple Operations:

For simple tasks like iterating over a collection or performing basic arithmetic, traditional loops are often more efficient and readable.
Be Cautious with Parallel Streams:

Parallel streams can provide performance benefits for large datasets, but they can introduce overhead. Use them judiciously.
Prioritize Readability and Maintainability:

Choose streams when they improve the clarity of your code. If using streams makes the code more complex or harder to understand, revert to traditional loops.
 */

/*
When Not to Use Streams
1. For Simple Operations:
If you only need to iterate over a collection or perform simple operations (e.g., summing values), traditional loops are often more efficient and easier to understand.

When Performance Is Critical:
Streams, especially parallel streams, can introduce overhead due to the abstraction they provide. For small datasets or performance-critical applications, traditional loops may be faster.

For Side Effects:
Streams are not designed for operations that involve side effects (e.g., modifying external state, printing to the console). If you need to perform side effects, traditional loops or other constructs might be more appropriate.
 */
/*
Conclusion
Traditional Loops are generally faster and more efficient for simple tasks and small datasets.
Streams offer more flexibility and readability, especially for complex transformations or when
working with large datasets or parallel processing.
If performance is critical (especially for simple operations), traditional loops are often
the better choice.
For complex operations or when you want to take advantage of parallel processing with large
datasets, Streams can be more efficient and more expressive.
Ultimately, the choice between Streams and Traditional Loops should be based on the specific
use case, readability, and performance requirements. Always benchmark in your specific context
 to make the best decision.
 */
public class Item_45_UseStreamsJudiciously {

    //Filtering and Collecting Data
    public void filterAndCollecting(){
        List<String> names = Arrays.asList("John", "Jane", "Doe", "Anna");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("J"))
                .toList();
    }

    //Parallel Stream Example (Large Dataset)
    public void parallelStream(){
        List<Integer> largeNumbers = IntStream.range(1, 1_000_000).boxed().collect(Collectors.toList());
        int sum = largeNumbers.parallelStream().mapToInt(Integer::intValue).sum();
    }
}
