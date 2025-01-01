package ClassesAndInterfaces;

/*
Why Designing Interfaces for Posterity is Crucial

Backward Compatibility: Once an interface is implemented by clients, changing it can break those implementations.
Widespread Usage: Interfaces tend to be widely adopted, making changes even more disruptive.
Longevity: Interfaces are a contract, and breaking that contract can lead to significant issues in dependent systems.
Guidelines for Designing Interfaces

Keep It Small and Focused: Avoid "fat" interfaces. Use the Interface Segregation Principle (ISP) to create smaller, more cohesive interfaces.
Avoid Adding Methods Later: Adding methods to an interface after its release can break existing implementations.
Provide Default Methods: Starting with Java 8, default methods allow you to add functionality to an interface without breaking existing implementations.
Use Abstract Classes for Evolution: If you anticipate frequent changes, consider providing an abstract class that implements the interface and contains default behavior.
 */
public class DesignInterfaceForPosterity {
    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print("Document");
        printer.printPreview("Document");
    }
}

interface Printer {
    void print(String document);

    default void printPreview(String document) {
        System.out.println("Preview: " + document);
    }
}

class SimplePrinter implements Printer {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

class Main {

}
