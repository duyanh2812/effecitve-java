package Chapter_6_LambdasAndStreams;

/*
 * If one of the standard functional interfaces does the job,
 * you should generally use it in preference to a purpose-built
 * functional interface.
 * <p>
 * Interface	Description	Method Signature
 * Predicate<T>	Represents a boolean-valued function of one argument.	boolean test(T t)
 * Function<T, R>	Represents a function that produces a result.	R apply(T t)
 * Consumer<T>	Represents an operation that accepts a single input argument and returns no result.	void accept(T t)
 * Supplier<T>	Represents a supplier of results.	T get()
 * BiFunction<T, U, R>	Represents a function that takes two arguments and produces a result.	R apply(T t, U u)
 */

import java.util.Map;
import java.util.function.IntPredicate;

/*
 * Don’t be tempted to use basic functional interfaces with boxed
 * primitives instead of primitive functional interfaces.
 *
 * Favor primitive functional interfaces (e.g., IntPredicate, DoubleFunction)
 * over their boxed counterparts (Predicate<Integer>, Function<Long, String>)
 * to improve performance and reduce memory usage.
 */

/*
 * Always annotate your functional interfaces with the @FunctionalInterface annotation.
 */
@FunctionalInterface
interface EldestEntryRemovalFunction<K, V> {
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}

public class Item_44_FavorTheUseOfStandardFunctionalInterfaces {
    public static void main(String[] args) {
        IntPredicate isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4)); // true

    }
}
