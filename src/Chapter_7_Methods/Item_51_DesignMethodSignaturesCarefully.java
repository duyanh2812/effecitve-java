package Chapter_7_Methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Item{}
class Customer{}

class Payment{}

class PaymentException extends Exception{}

//For parameter types, favor interfaces over classes
interface AccessorType{}



public class Item_51_DesignMethodSignaturesCarefully {
    /*
    1. Keep Methods Focused and Simple:
A method should do one thing and do it well. Avoid overloading a method with too many responsibilities, as it can make the method harder to understand and use.
A method should have a clear and descriptive name that reflects its purpose. The signature should convey the method's purpose without needing to examine the implementation.
     */
    public int calculateTotalPrice(List<Item> items) {
        // Clear and focused method that calculates total price
        return 0;
    }

    // Prefer two-element enum types to boolean parameters
    enum TemperatureScale { FAHRENHEIT, CELSIUS }



    // 2. Minimize the Number of Parameters:
    public void updateCustomerDetails(Customer customer) {
        // Using a single parameter object instead of multiple parameters
    }

    // 3. Prefer Descriptive Names:
    // Method names should clearly describe what the method does.
    //Use action verbs to indicate what the method does
    public void sendEmailNotification(String recipient, String message) {
        // Descriptive method name that clearly indicates its purpose
    }
    //4. Return Type Should Be Appropriate
    // The return type should match the expected result of the method
    // Avoid returning null or an empty collection unless it is a valid result
    // If returning an empty collection is acceptable, consider returning an immutable collection to prevent modifications.
    public List<Customer> findCustomersByName(String name) {
        // The return type clearly indicates that a list of customers is expected
        return new ArrayList<Customer>();
    }
    // 5. Avoid Overloading Methods Without Clear Differentiation
    // If you overload a method, ensure that the different versions of the method are clearly distinct in their purpose
    public void sendEmail(String recipient, String message) {
        // Send a simple email
    }

    public void sendEmail(String recipient, String subject, String message) {
        // Send an email with a subject
    }
    // 6. Use Varargs Carefully
    // as they can make the method signature less clear and can lead to unexpected behavior if misused
    // If the number of arguments is likely to vary widely, consider using a collection
    public void printMessages(String... messages) {
        // Varargs allows for a flexible number of message parameters
    }
    // 7. Use Optional Parameters When Appropriate
    // If a method has parameters that are optional, you can use method overloading, default values, or Optional to make the method signature clearer
    // Avoid having methods with a large number of parameters where many are optional
    public void createAccount(String username, String password, Optional<String> email) {
        // The email parameter is optional and represented as an Optional
    }
    // 8. Avoid Returning Void Unless Necessary:
    // Methods that return void should only do so when there is no meaningful result to return
    // Returning void can make the method harder to test, and it provides no feedback to the caller
    // If possible, return a meaningful result or an appropriate status code (e.g., boolean for success/failure)

    public boolean deleteUser(int userId) {
        // Returns a boolean indicating success or failure
        return true;
    }

    // 9. Consider Exceptions in Method Signatures:
    // If a method can throw an exception, it should be clearly indicated in the method signature
    // Avoid throwing generic exceptions; be specific about the type of exception thrown to make the method's behavior clear to callers
    public void processPayment(Payment payment) throws PaymentException {
        // Specific exception type is thrown to indicate payment processing failure
    }

    // Be Careful with Nullability:
    // Avoid passing null as a valid parameter unless explicitly allowed
    // Consider using annotations like @NonNull or @Nullable to indicate nullability expectations

    class OrderService {
        public Customer customer;
        public Order createOrder(Customer customer, List<Item> items) {
            if (customer == null || items == null || items.isEmpty()) {
                throw new IllegalArgumentException("Customer and items must not be null or empty");
            }
            // Logic to create the order
            return new Order();
        }

        public boolean cancelOrder(Order order) {
            if (order == null) {
                throw new IllegalArgumentException("Order must not be null");
            }
            // Logic to cancel the order
            return true;
        }
    }



}

class Order{}
