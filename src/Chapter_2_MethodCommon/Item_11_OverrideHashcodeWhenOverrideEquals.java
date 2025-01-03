package Chapter_2_MethodCommon;

/*
you must override hashCode every time you override equals,
or your program will not run correctly. Your hashCode method must obey the
general contract specified in Object and must do a reasonable job assigning
unequal hash codes to unequal instances. This is easy to achieve, if slightly
tedious, using the recipe on page 51. As mentioned in Item 10, the AutoValueframework provides a fine alternative to writing equals and hashCode
methods manually, and IDEs also provide some of this functionality.
 */
public class Item_11_OverrideHashcodeWhenOverrideEquals {
    private int hashCode; // Automatically initialized to 0
    private Short areaCode;
    private Short prefix;
    private Short lineNum;

    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = 31 * result + Short.hashCode(prefix);
            result = 31 * result + Short.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }
}
