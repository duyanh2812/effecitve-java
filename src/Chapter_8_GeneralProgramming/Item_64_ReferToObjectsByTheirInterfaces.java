package Chapter_8_GeneralProgramming;

import java.util.LinkedHashSet;
import java.util.Set;

/*
In practice, it should be apparent whether a given object has an appropriate interface.
If it does, your program will be more flexible and stylish if you use the interface to
refer to the object. If there is no appropriate interface, just use the least specific class
in the class hierarchy that provides the required functionality.
 */
class Son {
}

public class Item_64_ReferToObjectsByTheirInterfaces {
    public static void main(String[] args) {
        // Good - uses interface as type
        Set<Son> sonSet = new LinkedHashSet<>();
        // Bad - uses class as type!
        LinkedHashSet<Son> sonSet2 = new LinkedHashSet<>();
    }
}
