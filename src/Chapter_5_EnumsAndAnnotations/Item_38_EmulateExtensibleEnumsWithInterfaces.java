package Chapter_5_EnumsAndAnnotations;

import java.util.Arrays;
import java.util.Collection;

/*
n summary, while you cannot write an extensible enum type, you can emulate it by writing
 an interface to accompany a basic enum type that implements the interface. This allows
 clients to write their own enums (or other types) that implement the interface. Instances
  of these types can then be used wherever instances of the basic
 */
interface OperationInterface {
    double apply(double x, double y);
}

enum BasicOperation implements OperationInterface {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

enum ExtendedOperation implements OperationInterface {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };
    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

public class Item_38_EmulateExtensibleEnumsWithInterfaces {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static void test(Collection<? extends OperationInterface> opSet, double x, double y) {
        for (OperationInterface op : opSet)
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}
