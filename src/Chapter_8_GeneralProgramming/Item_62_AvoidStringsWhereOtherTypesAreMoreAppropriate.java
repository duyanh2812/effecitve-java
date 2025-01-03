package Chapter_8_GeneralProgramming;

import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Pattern;

/*
Lack of Type Safety: Strings don’t enforce constraints or validation,
leading to potential runtime errors.
Error-Prone: Strings require manual parsing and validation.
Inefficient: Strings consume more memory and are slower for operations compared to
specialized data types.
Reduced Clarity: The intent of the value can be unclear when using a string.

Use Appropriate Types:

Use int, double, or BigDecimal for numeric values.
Use enum for a fixed set of constants.
Use LocalDate or LocalDateTime for dates and times.
Use classes or records for structured data.

 */
public class Item_62_AvoidStringsWhereOtherTypesAreMoreAppropriate {
    public static void main(String[] args) {
        //BAD
        String age = "25"; // Misuse of string
        int nextYear = Integer.parseInt(age) + 1;
        //GOOD
        int age1 = 25;
        int nextYear1 = age1 + 1;
        //BAD
        String status = "ACTIVE"; // Prone to typos and invalid values
        if (status.equals("ACTIVE")) {
            System.out.println("Status is active.");
        }
        //GOOD
        enum Status { ACTIVE, INACTIVE }
        Status status2 = Status.ACTIVE;
        if (status2 == Status.ACTIVE) {
            System.out.println("Status is active.");
        }
        //BAD
        String date = "2025-01-01"; // Requires parsing and validation
        LocalDate parsedDate = LocalDate.parse(date);
        //GOOD
        LocalDate date2 = LocalDate.of(2025, 1, 1);
        //BAD
        String user = "John Doe, 30"; // Hard to parse and error-prone
        //GOOD
        record User(String name, int age) {}
        User user2 = new User("John Doe", 30);
        //Use a class or UUID instead of a string.
        UUID id = UUID.randomUUID();
        // Use classes or records to encapsulate related data.
        record Address(String street, String city, String zip) {}
        // Use Pattern instead of raw strings for regex patterns.
        Pattern pattern = Pattern.compile("\\d+");
        //Multilingual Text:
        //Use ResourceBundle or localization frameworks instead of hardcoding strings.
    }
}
