package Chapter_3_ClassesAndInterfaces;

/*
To summarize, you should reduce accessibility of program elements as much
as possible (within reason). After carefully designing a minimal public API, you
should prevent any stray classes, interfaces, or members from becoming part of
the API. `With the exception of public static final fields, which serve as constants,
public classes should have no public fields. Ensure that objects referenced by
public static final fields are immutable.
 */
import java.util.List;

public class Item_15_MinimizeAccessibility {
    private static final Item_15_MinimizeAccessibility[] PRIVATE_VALUES = {};
    public static final List<Item_15_MinimizeAccessibility> VALUES =
            List.of(PRIVATE_VALUES);
}
