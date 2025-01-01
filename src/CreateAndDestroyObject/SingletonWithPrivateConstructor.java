package CreateAndDestroyObject;

/*
This approach is similar to the public field approach, but it is more concise,
provides the serialization machinery for free, and provides an ironclad guarantee
against multiple instantiation, even in the face of sophisticated serialization or
reflection attacks. This approach may feel a bit unnatural, but a single-element
enum type is often the best way to implement a singleton. Note that you can’t
use this approach if your singleton must extend a superclass other than Enum
(though you can declare an enum to implement interfaces)
 */
public class SingletonWithPrivateConstructor {
}

// Singleton with public final field
class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
    }

    private Object readResolve() {
// Return the one true CreateAndDestroyObject.Elvis and let the garbage collector
// take care of the CreateAndDestroyObject.Elvis impersonator.
        return INSTANCE;
    }
}