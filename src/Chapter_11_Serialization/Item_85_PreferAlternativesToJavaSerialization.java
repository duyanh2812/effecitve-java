package Chapter_11_Serialization;

/*
 * Avoid Java Serialization:
 * It is insecure, fragile, and inefficient.
 * <p>
 * Avoid implementing Serializable for new classes.
 * Prefer Modern Alternatives:
 * Use JSON, Protobuf, Avro, or Kryo based on your use case.
 * <p>
 * If Unavoidable:
 * Limit the use of Java serialization.
 * Validate inputs during deserialization to mitigate security risks.
 * <p>
 * By adopting modern serialization frameworks, you ensure better security, performance,
 * and maintainability for your applications.
 */

// There is no reason to use Java serialization in any new system you write.
class Person {
    private String name;
    private int age;

    public Person() { // Default constructor for deserialization
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();

        // Serialize
        Person person = new Person("Alice", 30);
//        String json = mapper.writeValueAsString(person);
//        System.out.println("Serialized JSON: " + json);

        // Deserialize
//        Person deserializedPerson = mapper.readValue(json, Person.class);
//        System.out.println("Deserialized Person: " + deserializedPerson.getName());
    }
}

public class Item_85_PreferAlternativesToJavaSerialization {

}
