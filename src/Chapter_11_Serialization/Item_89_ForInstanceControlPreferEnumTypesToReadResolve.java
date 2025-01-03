package Chapter_11_Serialization;

/**
 * Prefer Enums:
 * <p>
 * Use enums for singleton instances as they are inherently safe, concise, and robust.
 * Avoid readResolve:
 * <p>
 * While readResolve works, it’s verbose and prone to errors.
 * Enums provide a cleaner and more modern approach to instance control.
 * By using enums, you simplify your code and avoid potential pitfalls related to serialization
 * and reflection, ensuring the singleton property is preserved under all circumstances.
 */

import java.io.*;

class SingletonNormal implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final SingletonNormal INSTANCE = new SingletonNormal();

    private SingletonNormal() {
        // Prevent instantiation
    }

    public static SingletonNormal getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        // Ensure the singleton property during deserialization
        return INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }
}


public class Item_89_ForInstanceControlPreferEnumTypesToReadResolve {
    public void singletonNormal() throws IOException, ClassNotFoundException {
        SingletonNormal instance1 = SingletonNormal.getInstance();

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            oos.writeObject(instance1);
        }

        // Deserialize
        SingletonNormal instance2;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instance2 = (SingletonNormal) ois.readObject();
        }

        System.out.println(instance1 == instance2); // true

    }

    public void singletonEnum() throws IOException, ClassNotFoundException {
        SingletonEnum instance1 = SingletonEnum.INSTANCE;

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            oos.writeObject(instance1);
        }

        // Deserialize
        SingletonEnum instance2;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instance2 = (SingletonEnum) ois.readObject();
        }

        System.out.println(instance1 == instance2); // true
    }

}
