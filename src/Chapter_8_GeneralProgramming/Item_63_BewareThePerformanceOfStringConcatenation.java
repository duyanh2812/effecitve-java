package Chapter_8_GeneralProgramming;

/*
To achieve acceptable performance, use a StringBuilder in place of a String to store
the statement under construction:
 */
public class Item_63_BewareThePerformanceOfStringConcatenation {

    private static final int LINE_WIDTH = 10;

    public String statement() {
        StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
        for (int i = 0; i < numItems(); i++)
            b.append(lineForItem(i));
        return b.toString();
    }

    private char[] lineForItem(int i) {
        return new char[10];
    }

    private int numItems() {
        return 10;
    }

}
