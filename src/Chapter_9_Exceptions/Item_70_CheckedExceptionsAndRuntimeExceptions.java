package Chapter_9_Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// 1. use checked exceptions for conditions from which the caller can reasonably be expected to recover.
// 2. Use runtime exceptions to indicate programming errors.
// 3. all of the unchecked throwables you implement should subclass
public class Item_70_CheckedExceptionsAndRuntimeExceptions {

    private void testUncheckException(String s) {
        if (s.isEmpty()) throw new NullPointerException();
    }

    /*
    Use Checked Exceptions for Recoverable Situations:
    If the caller can take some action to recover from the failure, use a checked exception.
    Example: File not found, invalid user input.
     */

}

class FileProcessor {
    public void readFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        // Read the file
    }
}

class FileProcessorMain {
    public static void main(String[] args) {
        FileProcessor processor = new FileProcessor();
        try {
            processor.readFile("example.txt");
        } catch (IOException e) {
            System.out.println(STR."Error reading file: \{e.getMessage()}");
            // Recovery logic, e.g., prompt user for a new file name
        }
    }
}

/*
Use Runtime Exceptions for Programming Errors:
If the issue represents a bug or an error in the program logic, use a runtime exception.
Example: Passing null to a method that doesn’t accept it, array index out of bounds.
Avoid Declaring Unchecked Exceptions in throws Clause:

Runtime exceptions do not need to be declared in the method's throws clause. Declaring them unnecessarily can clutter the API.
 */
class Calculator {
    public int divide(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator must not be zero");
        }
        return numerator / denominator;
    }
}

class CalculatorMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide(10, 2)); // Works fine
        System.out.println(calculator.divide(10, 0)); // Throws IllegalArgumentException
    }
}

/*
Avoid Overusing Checked Exceptions:

Too many checked exceptions can make APIs cumbersome to use. Consider alternatives like:
Returning an Optional or a special result object.
Wrapping checked exceptions in a custom runtime exception if they rarely occur.

 */

/*
Document Exceptions Clearly:
Use Javadoc to explain the conditions under which exceptions are thrown and how to handle them.
 */
class DocumentException {
    /**
     * Reads a file.
     *
     * @param fileName the name of the file to read
     * @throws IOException           if an I/O error occurs
     * @throws FileNotFoundException if the file does not exist
     */
    public void readFile(String fileName) throws IOException {
        // Implementation
    }
}

/*
Convert Checked to Runtime Exceptions When Necessary:
If a checked exception is unlikely to occur, consider wrapping it in a runtime
exception to simplify the API.
 */