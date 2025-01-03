package Chapter_11_Serialization;

/*
 * 1. Custom Serialization Logic:
 * Some fields may require special handling during serialization, such as encryption, compression, or exclusion of sensitive data.
 * Example: Encrypting a password field before serialization and decrypting it during deserialization.
 *
 * 2. Transient Fields:
 * Fields marked transient are not serialized by default. If you want to serialize these fields manually, you need to handle them in writeObject and readObject.
 *
 * 3. Validation:
 * You can validate the state of an object during deserialization to ensure it is consistent and valid.
 * Example: Checking if a field is non-null or within a specific range after deserialization.
 *
 * 4. Backwards Compatibility:
 * If the class structure changes over time (e.g., fields are added or removed), you can manage these changes in readObject to ensure compatibility with older serialized forms.
 *
 * 5. Avoiding Security Risks:
 * Deserialization can be a vector for attacks. Overriding readObject allows you to sanitize and validate input to prevent deserialization vulnerabilities.
 *
 * 6. Performance Optimization:
 * For large objects or objects with complex structures, you can optimize serialization by handling only the necessary fields.
 * <p>
 * Regardless of what serialized form you choose, declare an explicit serial version UID in every serializable class you write.
 * <p>
 * Do not change the serial version UID unless you want to break compatibility with all existing serialized instances of a class.
 */

/*
 * Regardless of what serialized form you choose, declare an explicit serial version UID in every serializable class you write.
 *
 * Do not change the serial version UID unless you want to break compatibility with all existing serialized instances of a class.
 */

import java.io.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password; // Transient field needs custom handling

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // Serialize non-transient fields
        oos.writeObject(encrypt(password)); // Serialize encrypted password
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Deserialize non-transient fields
        password = decrypt((String) ois.readObject()); // Deserialize and decrypt password
    }

    private String encrypt(String data) {
        return STR."ENCRYPTED_\{data}"; // Placeholder encryption
    }

    private String decrypt(String data) {
        return data.replace("ENCRYPTED_", ""); // Placeholder decryption
    }

    @Override
    public String toString() {
        return STR."User{username='\{username}', password='\{password}'}";
    }
}

public class Item_87_ConsiderUsingACustomSerializedForm {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("Alice", "password123");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println(deserializedUser); // User{username='Alice', password='password123'}
        }
    }
}
