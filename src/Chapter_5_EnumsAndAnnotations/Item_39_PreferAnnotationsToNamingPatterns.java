package Chapter_5_EnumsAndAnnotations;
/*
Advantages of Annotations Over Naming Patterns
Type Safety:

Annotations are checked by the compiler, reducing errors.
Naming patterns rely on manual adherence and are error-prone.
Clarity:

Annotations explicitly convey intent, making the code easier to understand.
Naming patterns require implicit knowledge of the convention.
Extensibility:

Annotations can carry additional metadata (e.g., @Test(timeout = 1000)).
Naming patterns are limited to what the name can convey.
Framework Support:

Many tools and frameworks (e.g., JUnit, Spring) rely on annotations to provide functionality.
Naming patterns require custom implementations.
Summary of Best Practices
Avoid Naming Patterns:

They are brittle, error-prone, and lack extensibility.
Leverage Annotations:

Use built-in annotations (e.g., @Override, @Test) where applicable.
Create custom annotations for specific use cases.
Use Annotation Processing:

Use tools like reflection or annotation processors to handle annotations programmatically.
By using annotations instead of naming patterns, you can create more robust, readable, and maintainable code.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    Class<? extends Exception> value();
    String description() default "No description";
}

class CalculatorTest {
    @Test(value = NullPointerException.class,description = "Tests subtraction functionality")
    public void addition() {
        System.out.println("Testing addition...");
    }

    @Test(value = NullPointerException.class, description = "Tests subtraction functionality")
    public void subtraction() {
        System.out.println("Testing subtraction...");
    }
}

public class Item_39_PreferAnnotationsToNamingPatterns {
    public static void main(String[] args) {
//        CalculatorTest test= new CalculatorTest();
//        test.addition();
//        test.subtraction();
        for (Method method : CalculatorTest.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                System.out.println(STR."Executing: \{method.getName()}");
                System.out.println(STR."Description: \{test.description()}");
                System.out.println(STR."Value: \{test.value()}");
                try {
                    method.invoke(new CalculatorTest());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
