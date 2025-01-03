package Chapter_7_Methods;

import java.util.List;

/*
In summary, varargs are invaluable when you need to define methods with a variable
 number of arguments. Precede the varargs parameter with any required parameters,
 and be aware of the performance consequences of using varargs.
 */
public class Item_53_UseVarargsJudiciously {

    static int min(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }

    public void foo() { }
    public void foo(int a1) { }
    public void foo(int a1, int a2) { }
    public void foo(int a1, int a2, int a3) { }
    public void foo(int a1, int a2, int a3, int... rest) { }

    // Use Varargs Only When Necessary:
    public void addNumbers(List<Integer> numbers) {
        // Process list
    }
    // If the number of arguments is fixed or can be represented more clearly with a collection (like a List), avoid varargs.
    // Avoid Overloading with Varargs: DON'T DO THIS!
    public void process(int... values) {
        System.out.println("Varargs method");
    }

    public void process(int value) {
        System.out.println("Single int method");
    }
    // Avoid Performance Issues:
    // Varargs methods incur a slight performance cost because the arguments are placed into an array at runtime.
    // If performance is critical, consider alternatives.
}
