package Chapter_7_Methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
In summary, never return null in place of an empty array or collection.
It makes your API more difficult to use and more prone to error, and it has no
performance advantages.

 */
class Cheese {
}

public class Item_54_ReturnEmptyCollectionsOrArraysNOTNull {
    private final List<Cheese> cheesesInStock = new ArrayList<>();

    public List<Cheese> getCheeses() {
        return cheesesInStock.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(cheesesInStock);
    }

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    public Cheese[] getCheesesArr() {
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }
}
