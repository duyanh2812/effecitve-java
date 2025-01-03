package Chapter_3_ClassesAndInterfaces;

/*
To make a class immutable, follow these five rules:
1. Don’t provide methods that modify the object’s state (known as
mutators).
2. Ensure that the class can’t be extended.
3. Make all fields final.
4. Make all fields private.
5. Ensure exclusive access to any mutable components.
 */
public class Item_17_MinimizeMutability {
}

class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}