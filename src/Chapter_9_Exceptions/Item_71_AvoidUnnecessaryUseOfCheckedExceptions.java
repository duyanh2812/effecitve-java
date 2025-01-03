package Chapter_9_Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

/*
In summary, when used sparingly, checked exceptions can increase the reliability of programs;
when overused, they make APIs painful to use. If callers won’t be able to recover from failures,
throw unchecked exceptions. If recovery may be possible and you want to force callers to handle
exceptional conditions, first consider returning an optional. Only if this would provide
insufficient information in the case of failure should you throw a checked exception.
 */

/*
Minimize Checked Exceptions:

Use checked exceptions only when the caller is expected to recover from the condition.
Avoid using them for rare or unrecoverable conditions.
Use Alternatives:

Return Optional for methods that might not produce a result.
Use runtime exceptions for programming errors or rare conditions.
Document Behavior:

Clearly document failure conditions in the method's Javadoc so callers know what to expect, even if no exceptions are used.
Provide Context in Exceptions:

If you use a checked exception, include detailed context in the exception message to help the caller handle it effectively.
Test API Usability:

Design APIs with the user in mind. If handling exceptions feels cumbersome, reconsider whether they are necessary.

 */
class UserNotFoundException extends IOException {
    public UserNotFoundException(String userIdIsInvalid) {
    }
}

public class Item_71_AvoidUnnecessaryUseOfCheckedExceptions {
    //    Unnecessary Checked Exception
    public String getUserById(String id) throws UserNotFoundException {
        if (id == null || id.isEmpty()) {
            throw new UserNotFoundException("User ID is invalid");
        }
        // Fetch user logic
        return "User";
    }

    // Improved Version: Use Optional
    public Optional<String> getUserById2(String id) {
        if (id == null || id.isEmpty()) {
            return Optional.empty();
        }
        // Fetch user logic
        return Optional.of("User");
    }

    // checked exception is appropriate because the caller can recover from the error.
    public void processFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(STR."File not found: \{fileName}");
        }
        // Process the file
    }


}
