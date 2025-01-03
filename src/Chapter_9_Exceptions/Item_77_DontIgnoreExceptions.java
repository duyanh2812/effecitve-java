package Chapter_9_Exceptions;

import java.io.IOException;

// 1. An empty catch block defeats the purpose of exceptions,
// 2. If you choose to ignore an exception, the catch block should contain a comment
// explaining why it is appropriate to do so, and the variable should be named ignored
public class Item_77_DontIgnoreExceptions {

    public static void main(String[] args) {
        // 1. Logging the Exception:
        try {
            someMethod();
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Log the stack trace for debugging
        }

        // 3. Handling Gracefully:
        try {
            someMethod();
        } catch (IOException e) {
            System.out.println("Could not complete the operation. Retrying...");
            retryMethod(); // Attempt a retry or provide an alternative
        }

        // 4. Wrapping in a RuntimeException:
        try {
            someMethod();
        } catch (IOException e) {
            throw new RuntimeException("Operation failed", e);
        }

        // 5. In rare cases, you might ignore exceptions intentionally, but you should document why:
        try {
            someCleanupMethod();
        } catch (Exception e) {
            // Exception ignored because cleanup is non-critical
        }

        // 6. Even in such cases, it's better to log the exception:
        try {
            someCleanupMethod();
        } catch (Exception e) {
            System.err.println(STR."Cleanup failed: \{e.getMessage()}");
        }


    }

    private static void someCleanupMethod() {
    }

    private static void retryMethod() {
    }

    // 2. Propagating the Exception:
    public void performTask() throws IOException {
        someMethod(); // Let the caller handle the exception
    }

    private static void someMethod() throws IOException {

    }
}
