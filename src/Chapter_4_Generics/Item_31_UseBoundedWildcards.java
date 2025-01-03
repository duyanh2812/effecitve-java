package Chapter_4_Generics;

import java.util.Collection;
import java.util.Iterator;

/*
Benefits of Bounded Wildcards
Increased API Flexibility:

APIs can handle a wider range of types without sacrificing type safety.
Improved Type Safety:

By explicitly specifying bounds, you prevent invalid operations at compile time.
Clearer Intent:

The use of ? extends and ? super clarifies whether a type is being produced or consumed.
 */
public class Item_31_UseBoundedWildcards {
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }

        Iterator<? extends T> iterator = c.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }
}
