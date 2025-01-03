package Chapter_10_Concurrency;

/**
 * Under most circumstances, normal initialization is preferable to lazy initialization.
 */

class FieldType {
}

public class Item_83_UseLazyInitializationJudiciously {
    // If you use lazy initialization to break an initialization circularity, use a
    // synchronized accessor because it is the simplest, clearest alternative:
    private FieldType field;

    private synchronized FieldType getField() {
        if (field == null)
            field = computeFieldValue();
        return field;
    }

    private FieldType computeFieldValue() {
        return new FieldType();
    }


    // If you need to use lazy initialization for performance on an instance field,
    // use the double-check idiom.
    private volatile FieldType field2;

    private FieldType getField2() {
        FieldType result = field2;
        if (result == null) { // First check (no locking)
            synchronized (this) {
                if (field2 == null) {
                } // Second check (with locking)
                field2 = result = computeFieldValue();
            }
        }
        return result;
    }


// If you need to use lazy initialization for performance on a static field, use the lazy
// initialization holder class idiom.

    private static class FieldHolder {
        static final FieldType field3 = computeFieldValue();

        private static FieldType computeFieldValue() {
            return null;
        }
    }

    private static FieldType getField3() {
        return FieldHolder.field3;
    }
}




