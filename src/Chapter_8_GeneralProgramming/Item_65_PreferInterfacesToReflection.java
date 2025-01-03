package Chapter_8_GeneralProgramming;

import java.lang.reflect.Method;

/*
Reflection Is Powerful but Risky:

Reflection allows you to inspect and modify classes, methods, and fields dynamically at runtime. While this can be useful in some scenarios (e.g., frameworks, libraries), it often leads to performance overhead and loss of type safety.
Reflection bypasses compile-time checking, which can lead to runtime errors if the expected fields or methods do not exist.
Performance Overhead:

Reflection operations are typically slower than direct method calls or field access due to the need to perform checks and lookups at runtime.
Reflection also prevents certain optimizations (like inlining) that the JVM might apply to direct code.
Loss of Type Safety:

Reflection works with raw types and doesn’t offer compile-time type checking. This makes the code more error-prone and harder to refactor.
Type-related errors are only caught at runtime, which can lead to unexpected crashes or bugs.
Maintainability and Readability:

Reflection-based code is often harder to understand and maintain because it’s less explicit and more abstract.
Code that uses interfaces and polymorphism is easier to follow and refactor.
Interfaces and Polymorphism:

Interfaces allow you to design flexible and extensible systems by defining contracts that can be implemented by various classes. This leads to better separation of concerns and more maintainable code.
Polymorphism allows you to invoke methods on objects without needing to know their exact types, avoiding the need for reflection.
 */
public class Item_65_PreferInterfacesToReflection {
}

//Using Reflection (Bad)
class ReflectionExample {
    public static void invokeMethod(Object obj) throws Exception {
        Method method = obj.getClass().getMethod("someMethod");
        method.invoke(obj);
    }
}

//Using Interfaces (Good)
interface Action {
    void performAction();
}

class ConcreteAction implements Action {
    @Override
    public void performAction() {
        System.out.println("Action performed!");
    }
}

class InterfaceExample {
    public static void executeAction(Action action) {
        action.performAction();
    }
}

/*
When to Use Reflection
Reflection should be used in specific situations where the benefits outweigh the drawbacks. Some common use cases include:

Frameworks and Libraries:

Frameworks like Spring or Hibernate use reflection to manage objects dynamically, inject dependencies, or map objects to database tables.
Serialization/Deserialization:

Reflection can be useful for dynamically creating objects from data formats like JSON or XML.
Dynamic Proxy Creation:

Reflection is used in libraries that generate proxy objects at runtime, such as Java's Proxy class for implementing interfaces dynamically.
Testing and Debugging:

Reflection can be useful in testing or debugging scenarios where you need to inspect private fields or methods.

 */