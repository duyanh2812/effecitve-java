package Chapter_7_Methods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Item_55_ReturnOptionalsJudiciously {
    // For Methods That Might Not Return a Value:
    public Optional<String> findUserByUsername(String username) {
        if ("admin".equals(username)) {
            return Optional.of("Admin User");
        }
        return Optional.empty();
    }

    Map<String, String> configMap = new HashMap<>();

    //To Avoid Returning null:
    public Optional<String> getConfig(String key) {
        String value = configMap.get(key);
        return Optional.ofNullable(value);
    }

    // When NOT to Use Optional
    // 1. As a Field or Parameter:
    // BAD
    public class User {
        private Optional<String> email; // Avoid this
    }

    public void setEmail(Optional<String> email) { // Avoid this
    }

    String value;

    // 2. In Performance-Critical Code:
    // BAD
    public String getValueOrDefault() {
        return Optional.ofNullable(value).orElse("default"); // Creates unnecessary Optional object
    }

    //INSTEAD
    public String getValueOrDefault2() {

        return value != null ? value : "default";
    }

    // When a Value is Always Present:
    // Guidelines for Using Optional Judiciously
    // 1. Use Optional.empty() for No Value:
    public Optional<String> findEmailByUsername(String username) {
        return username.equals("admin") ? Optional.of("admin@example.com") : Optional.empty();
    }

    // 2. Use Optional.of() and Optional.ofNullable() Appropriately:
    public void optionalNullAble(String possibleNullValue) {
        Optional<String> email = Optional.of("admin@example.com"); // Non-null value
        Optional<String> maybeNullEmail = Optional.ofNullable(possibleNullValue); // Potentially null value
    }

    // Provide Clear Alternatives for Empty Values:
    //Use orElse, orElseGet, or orElseThrow to handle empty Optional values.
    public void test() {
        Optional<String> optionalValue = Optional.of("");
        String value = optionalValue.orElseGet(() -> "123");
    }

    // 1. Convert Optional to Stream
    public static void optional1(String[] args) {
        Optional<String> optionalValue = Optional.of("Hello, World!");

        Stream<String> stream = optionalValue.stream();
        stream.forEach(System.out::println); // Prints: Hello, World!
    }

    // 2. Flatten Nested Optionals
    public static void optional2(String[] args) {
        List<Optional<String>> optionalList = List.of(
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B"),
                Optional.of("C")
        );

        List<String> result = optionalList.stream()
                .flatMap(Optional::stream) // Flatten the Optional into Stream
                .collect(Collectors.toList());

        System.out.println(result); // Output: [A, B, C]
    }

    // 3. Filter and Process Optional Values
    public static void optional3(String[] args) {
        Optional<String> optionalValue = Optional.of("Hello, World!");

        optionalValue.stream()
                .filter(value -> value.startsWith("Hello"))
                .map(String::toUpperCase)
                .forEach(System.out::println); // Prints: HELLO, WORLD!
    }

    // 4. Combining Multiple Optionals
    public static void optional4(String[] args) {
        Optional<String> opt1 = Optional.of("Java");
        Optional<String> opt2 = Optional.of("Streams");
        Optional<String> opt3 = Optional.empty();

        Stream.of(opt1, opt2, opt3)
                .flatMap(Optional::stream) // Combine non-empty Optionals
                .forEach(System.out::println); // Prints: Java, Streams
    }

    // 5. Transforming Optional Values
    public static void optional5(String[] args) {
        Optional<String> optionalValue = Optional.of("Functional Programming");

        optionalValue.stream()
                .map(String::length)
                .forEach(System.out::println); // Prints: 22
    }

    // 6. Handling Default Values
    public static void optional6(String[] args) {
        Optional<String> optionalValue = Optional.empty();

        String result = optionalValue
                .stream()
                .findFirst() // Since it's empty, no value is found
                .orElse("Default Value");

        System.out.println(result); // Prints: Default Value
    }

    // 7. Aggregating Values from Optionals
    public static void optional7(String[] args) {
        List<Optional<Integer>> optionalNumbers = List.of(
                Optional.of(1),
                Optional.of(2),
                Optional.empty(),
                Optional.of(3)
        );

        int sum = optionalNumbers.stream()
                .flatMap(Optional::stream) // Flatten into a stream of Integers
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum();

        System.out.println("Sum: " + sum); // Prints: Sum: 6
    }




}
