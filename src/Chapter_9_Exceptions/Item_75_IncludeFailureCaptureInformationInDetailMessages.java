package Chapter_9_Exceptions;

/*
 * 1. To capture a failure, the detail message of an exception should contain the values of
 * all parameters and fields that contributed to the exception
 * <p>
 * 2. do not include passwords, encryption keys, and the like in detail messages.
 * <p>
 * Capture Relevant Information:
 * Include key details about the failure, such as invalid input values, expected ranges, and environmental conditions.
 * Avoid Sensitive Data:
 * <p>
 * Do not include sensitive information like passwords, API keys, or personal data in exception messages.
 * Use Consistent Formatting:
 * <p>
 * Follow a standard format for exception messages to make logs easier to analyze.
 * Leverage Logging:
 * <p>
 * Use logs to capture more detailed context if the exception message becomes too verbose.
 * Test for Clarity:
 * <p>
 * Review exception messages to ensure they provide enough information for debugging without overwhelming or confusing the user.
 */

import java.io.File;
import java.io.IOException;

public class Item_75_IncludeFailureCaptureInformationInDetailMessages {
    public void setAge(int age) {
        throw new IllegalArgumentException(STR."Invalid argument: age must be between 0 and 150, but was \{age}");
    }

    public void writeFile(File file) throws IOException {
        String availableDiskSpace = "128G";
        throw new IOException(STR."Failed to write to file: \{file.getAbsolutePath()} (disk space: \{availableDiskSpace} bytes)");
    }
}
