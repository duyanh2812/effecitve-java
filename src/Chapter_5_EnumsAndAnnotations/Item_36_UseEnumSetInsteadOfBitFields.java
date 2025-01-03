package Chapter_5_EnumsAndAnnotations;
/*
In summary, just because an enumerated type will be used in sets, there is no reason to represent
it with bit fields. The EnumSet class combines the conciseness and performance of bit fields
with all the many advantages of enum types described in Item 34. The one real disadvantage of EnumSet
is that it is not, as of Java 9, possible to create an immutable EnumSet, but this will likely
be remedied in an upcoming release. In the meantime, you can wrap an EnumSet with Collections.
unmodifiableSet, but conciseness and performance will suffer.
 */

import java.util.EnumSet;
import java.util.Set;

class Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void applyStyles(Set<Style> styles) {
    }
}

public class Item_36_UseEnumSetInsteadOfBitFields {
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}
