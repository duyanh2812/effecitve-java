package Chapter_8_GeneralProgramming;

import java.math.BigDecimal;

/*
In summary, don’t use float or double for any calculations that require an exact answer.
Use BigDecimal if you want the system to keep track of the decimal point and you don’t
mind the inconvenience and cost of not using a primitive type. Using BigDecimal has the
added advantage that it gives you full control over rounding, letting you select from
eight rounding modes whenever an operation that entails rounding is performed.
 */
public class Item_60_AvoidFloatAndDoubleIfExactAnswers {
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println(STR."\{itemsBought} items bought.");
        System.out.println(STR."Money left over: $\{funds}");
    }
}
