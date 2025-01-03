package Chapter_9_Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/*
Preserve Abstraction:

The exceptions thrown by a method should reflect the abstraction of the method.
Avoid leaking lower-level implementation details (e.g., exceptions from underlying libraries or frameworks).
Translate Exceptions:

If a lower-level method throws an exception that doesn’t make sense at the higher abstraction level, catch it and throw a more appropriate exception.
Example: Translating a SQLException into a custom DataAccessException in a data access layer.
Avoid Over-Translation:

Don’t translate exceptions unnecessarily if the lower-level exception is meaningful and fits the abstraction.
Example: A FileNotFoundException can be propagated as-is because it’s meaningful at most abstraction levels.
Use Meaningful Exceptions:

Ensure that the exceptions provide enough context to help the caller understand the issue and take corrective action.
Include relevant information in the exception message.
Document Exceptions Clearly:

Use Javadoc to document the exceptions that a method can throw, specifying the conditions under which they are thrown.
 */
class DataAccessException extends SQLException {
    public DataAccessException(String failedToSaveData, SQLException e) {
    }
}

public class Item_73_ThrowExceptionsAppropriateToTheAbstraction {
    // 1. Example 1: Leaking Implementation Details
    public void saveData2(String data) throws SQLException {
        // Save data to database
        throw new SQLException("Database error");
    }

    //Solution: Translate the exception.
    public void saveData(String data) throws DataAccessException {
        try {
            saveData2(data);
            // Save data to database
        } catch (SQLException e) {
            throw new DataAccessException("Failed to save data", e);
        }
    }

    // Example 2: Avoiding Over-Translation
    public void loadFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        // Load file logic
    }
    //FileNotFoundException is appropriate because it directly relates to the operation and
    // abstraction of loading a file.
}
