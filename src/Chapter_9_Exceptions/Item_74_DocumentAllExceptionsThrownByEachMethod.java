package Chapter_9_Exceptions;

import java.io.File;
import java.io.IOException;

/*
 * Always declare checked exceptions individually, and document precisely the conditions under
 * which each one is thrown
 * <p>
 * Use the Javadoc @throws tag to document each exception that a method can throw, but do not
 * use the throws keyword on unchecked exceptions
 * <p>
 * If an exception is thrown by many methods in a class for the same reason, you can document
 * the exception in the class’s documentation comment
 */
class User {
}

public class Item_74_DocumentAllExceptionsThrownByEachMethod {
    /**
     * Retrieves a user by their ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the user with the specified ID
     * @throws IllegalArgumentException if the userId is null or empty
     * @throws UserNotFoundException    if no user with the specified ID exists
     */
    public User getUserById(String userId) throws UserNotFoundException {
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID must not be null or empty");
        }
        // Fetch user logic
        return new User();
    }

    /**
     * Processes a file.
     *
     * @param file the file to process
     * @throws IllegalArgumentException if the file is null
     * @throws IOException              if an I/O error occurs during processing
     */
    public void processFile(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File must not be null");
        }
        // Processing logic
    }
}
/*
 * Documenting exceptions ensures that developers understand the failure scenarios of your API.
 * Use the @throws tag to describe each exception and the conditions under which it occurs.
 * Focus on exceptions that are relevant to the caller and avoid overloading them with unnecessary details.
 * Keep documentation concise, clear, and up-to-date to maintain API usability and clarity.
 */
