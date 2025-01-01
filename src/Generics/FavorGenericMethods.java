package Generics;

import java.util.Collection;
import java.util.Objects;

/*
In summary, generic methods, like generic types, are safer and easier to use
than methods requiring their clients to put explicit casts on input parameters and
return values. Like types, you should make sure that your methods can be used
without casts, which often means making them generic. And like types, you
should generify existing methods whose use requires casts. This makes life
easier for new users without breaking existing clients
 */
public class FavorGenericMethods {

    public static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }
}
