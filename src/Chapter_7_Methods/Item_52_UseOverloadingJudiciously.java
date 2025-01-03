package Chapter_7_Methods;

/*
Item 52 of Effective Java advises you to use overloading judiciously to:

Improve readability and flexibility without making the code overly complex or ambiguous.
Avoid overloading methods in ways that can lead to confusion, especially when the
differences between overloaded methods are subtle.
Ensure that overloaded methods have clear and distinct purposes, and document them
well to avoid confusion for other developers.
 */
public class Item_52_UseOverloadingJudiciously {

}

class FileManager {
    public void saveFile(String fileName) {
        // Save file with default settings
    }

    public void saveFile(String fileName, String content) {
        // Save file with content
    }

    public void saveFile(String fileName, String content, boolean overwrite) {
        // Save file with content and overwrite flag
    }

    // 1. Ensure Clear Distinction Between Overloaded Methods:
    //  BAD
    public void processOrder(String orderId) {
        // Process order by orderId
    }

    public void processOrder(int orderId) {
        // Process order by orderId
    }

    // 2. Avoid Overloading Based on Primitive vs. Wrapper Types:
    // BAD
    public void process(int value) {
        // Process int value
    }

    public void process(Integer value) {
        // Process Integer value
    }

    // 3. Use Varargs or Collections to Simplify Overloading:
    // GOOD
    public void printMessages(String... messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }


}
