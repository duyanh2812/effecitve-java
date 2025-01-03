package Chapter_11_Serialization;

import java.io.*;
import java.util.Date;

/*
 * Define a Static Nested Proxy Class:
 * <p>
 * The proxy class is a static nested class that implements Serializable.
 * It captures the logical state of the enclosing class.
 * Replace the Object with Its Proxy During Serialization:
 * <p>
 * Override the writeReplace method to return the proxy object.
 * Reconstruct the Original Object During Deserialization:
 * <p>
 * The proxy class implements readResolve to reconstruct the original object.
 */
class Period implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.after(end)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    // Serialization proxy class
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1L;

        private final Date start;
        private final Date end;

        SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        private Object readResolve() {
            return new Period(start, end);
        }
    }

    // Replace the instance with its proxy during serialization
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // Prevent default deserialization
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}

public class Item_90_ConsiderSerializationProxiesInsteadOfSerializedInstances {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Period period = new Period(new Date(), new Date(System.currentTimeMillis() + 10000));

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("period.ser"))) {
            oos.writeObject(period);
        }

        // Deserialize
        Period deserializedPeriod;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("period.ser"))) {
            deserializedPeriod = (Period) ois.readObject();
        }

        System.out.println(STR."Deserialized Period: Start = \{deserializedPeriod.getStart()}, End = \{deserializedPeriod.getEnd()}");
    }
}

/*
 * Benefits of Serialization Proxy:
 * Ensures consistent and valid state of the object after deserialization.
 * Reduces the risk of serialization vulnerabilities.
 * Simplifies handling of backward compatibility when class structure changes.
 * By using the serialization proxy pattern, you gain greater control over the serialization process,
 * improving both robustness and security
 */
