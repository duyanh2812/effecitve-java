package Chapter_8_GeneralProgramming;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Element {

}

public class Item_57_MinimizeScopeOfLocalVariables {
    //
    public static void main(String[] args) {
        // Preferred idiom for each
        Set<Element> c = new HashSet<>();
        for (Element e : c) {
        }
        // Prefer for loop to while loop
        for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
            Element e = i.next();
        }
        // The most powerful technique for minimizing the scope of a local variable is to declare
        // it where it is first used.
        int result = calculate();
    }

    private static int calculate() {
        return 0;
    }
}
