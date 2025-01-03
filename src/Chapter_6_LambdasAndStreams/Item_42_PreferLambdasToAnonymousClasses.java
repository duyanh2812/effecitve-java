package Chapter_6_LambdasAndStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

/*
In summary, as of Java 8, lambdas are by far the best way to represent small
function objects. Don’t use anonymous classes for function objects unless you have to create
instances of types that aren’t functional interfaces. Also, remember that lambdas make it so
easy to represent small function objects that it opens the door to functional programming
techniques that were not previously practical in Java.
 */
public class Item_42_PreferLambdasToAnonymousClasses {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("1", "32", "2");

        words.sort(Comparator.comparingInt(String::length));
        System.out.println(words);
    }
}

enum Operation {
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
