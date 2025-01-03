package Chapter_1_CreateAndDestroyObject;

import java.util.regex.Pattern;

public class Item_6_AvoidCreatingUnnecessaryObjects {
    public static void main(String[] args) {
        String s = new String("bikini"); // DON'T DO THIS!
// The improved version is simply the following:
        String s1 = "bikini";
    }
}

class RomanNumerals {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}