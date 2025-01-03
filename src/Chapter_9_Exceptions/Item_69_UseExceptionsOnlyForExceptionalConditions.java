package Chapter_9_Exceptions;

import java.util.ArrayList;
import java.util.List;

//Exceptions are, as their name implies, to be used only for exceptional conditions;
// they should never be used for ordinary control flow.
//A well-designed API must not force its clients to use exceptions for ordinary control flow.
public class Item_69_UseExceptionsOnlyForExceptionalConditions {
    public static void main(String[] args) {
        //BAD
        try {
            int i = 0;
            while (true)
                i++;
            //range[i++].climb();
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //GOOD
        List<String> range = new ArrayList<>();
        for (String m : range)
            System.out.println(m);
    }
}
