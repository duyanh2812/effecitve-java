package Chapter_2_MethodCommon;

/*
whenever you implement a value class that has a sensible
ordering, you should have the class implement the Comparable interface so
that its instances can be easily sorted, searched, and used in comparison-based
collections. When comparing field values in the implementations of the
compareTo methods, avoid the use of the < and > operators. Instead, use the
static compare methods in the boxed primitive classes or the comparator
construction methods in the Comparator interface.
 */


public class Item_14_ImplementComparable implements Comparable<Item_14_ImplementComparable> {
    // Comparable with comparator construction methods
    Short areaCode;
    Short prefix;
    Short lineNum;

    @Override
    // Multiple-field Comparable with primitive fields
    public int compareTo(Item_14_ImplementComparable pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, pn.prefix);
            if (result == 0)
                result = Short.compare(lineNum, pn.lineNum);
        }
        return result;
    }
}


