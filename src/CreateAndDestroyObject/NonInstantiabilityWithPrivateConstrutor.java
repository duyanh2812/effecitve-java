package CreateAndDestroyObject;

/*
As a side effect, this idiom also prevents the class from being subclassed. All
constructors must invoke a superclass constructor, explicitly or implicitly, and a
subclass would have no accessible superclass constructor to invoke.
 */
public class NonInstantiabilityWithPrivateConstrutor {
}

// Noninstantiable utility class
class UtilityClass {
    // Suppress default constructor for noninstantiability
    /*
    The AssertionError isn’t strictly required, but it provides insurance in case
    the constructor is accidentally invoked from within the class. It guarantees the
    class will never be instantiated under any circumstances.
     */
    private UtilityClass() {
        throw new AssertionError();
    }
    // Remainder omitted
}