package Chapter_11_Serialization;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * To summarize, anytime you write a readObject method, adopt the mind- set that you are writing a public constructor that must produce a valid instance regardless of what byte stream it is given. Do not assume that the byte stream represents an actual serialized instance. While the examples in this item concern a class that uses the default serialized form, all of the issues that were raised apply equally to classes with custom serialized forms. Here, in summary form, are the guidelines for writing a readObject method:
 * • For classes with object reference fields that must remain private, defensively copy each object in such a field. Mutable components of immutable classes fall into this category.
 * • Check any invariants and throw an InvalidObjectException if a check fails. The checks should follow any defensive copying.
 * • If an entire object graph must be validated after it is deserialized, use the ObjectInputValidation interface (not discussed in this book).
 * • Do not invoke any overridable methods in the class, directly or indirectly.
 */

class ReadObjectTest {
    Date start;
    Date end;

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // Check that our invariants are satisfied
        if (start.compareTo(end) > 0)
            throw new InvalidObjectException(start + " after " + end);
    }
}

public class Item_88_WriteReadObjectMethodsDefensively implements Serializable {
    Date start;
    Date end;

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        // Defensively copy our mutable components
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        // Check that our invariants are satisfied
        if (start.compareTo(end) > 0)
            throw new InvalidObjectException(start + " after " + end);
    }


}
