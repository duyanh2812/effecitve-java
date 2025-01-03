package Chapter_4_Generics;

import java.util.HashMap;
import java.util.Map;

/*
Using Class<T> as a Key:

The Class<T> object serves as a type token, uniquely identifying the type of the object stored in the map.
Storing Objects:

When you call putFavorite, the object is stored in the map, and its type is associated with its Class<T> token.
Retrieving Objects:

When you call getFavorite, the method uses the Class.cast method to safely cast the object back to its original type.
Type Safety:

The compiler ensures that only objects of the correct type are stored and retrieved, preventing runtime ClassCastException.

 */
public class Item_33_TypesafeHeterogeneousContainers {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        // Store favorites
        favorites.putFavorite(String.class, "Effective Java");
        favorites.putFavorite(Integer.class, 42);
        favorites.putFavorite(Class.class, Favorites.class);

        // Retrieve favorites
        String favoriteBook = favorites.getFavorite(String.class);
        Integer favoriteNumber = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        // Print results
        System.out.println(STR."Favorite Book: \{favoriteBook}");
        System.out.println(STR."Favorite Number: \{favoriteNumber}");
        System.out.println(STR."Favorite Class: \{favoriteClass.getName()}");
    }
}

class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}