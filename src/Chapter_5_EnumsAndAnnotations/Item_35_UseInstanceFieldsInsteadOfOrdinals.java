package Chapter_5_EnumsAndAnnotations;

/*
The Enum specification has this to say about ordinal:
“Most programmers will have no use for this method.
 It is designed for use by general-purpose enum-
 based data structures such as EnumSet and EnumMap.”
 Unless you are writing code with this character,
 you are best off avoiding the ordinal method entirely.
 */
public class Item_35_UseInstanceFieldsInsteadOfOrdinals {
}

enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);
    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}

