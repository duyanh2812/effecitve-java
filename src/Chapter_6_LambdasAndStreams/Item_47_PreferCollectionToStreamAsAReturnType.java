package Chapter_6_LambdasAndStreams;

import java.util.ArrayList;
import java.util.List;/*
Collections are more familiar, flexible, and reusable.
Streams are consumable and lazy, which can lead to confusion and unexpected behavior.
Returning a Collection makes your API more intuitive and easier to use.
 */
import java.util.stream.Stream;

public class Item_47_PreferCollectionToStreamAsAReturnType {

    // Preferred: Returning Collection
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        return names;
    }

    // Not Preferred: Returning Stream
    public Stream<String> getNames2() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        return names.stream();
    }
}

