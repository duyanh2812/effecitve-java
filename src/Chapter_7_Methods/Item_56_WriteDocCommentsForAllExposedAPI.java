package Chapter_7_Methods;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Item_56_WriteDocCommentsForAllExposedAPI {
}

// To document your API properly, you must precede every exported class, interface,
// constructor, method, and field declaration with a doc comment.
// The doc comment for a method should describe succinctly the contract between the method and its client.
interface TestInterface<E> {

    /**
     * Returns the element at the specified position in this list.
     *
     * <p>This method is <i>not</i> guaranteed to run in constant
     * time. In some implementations it may run in time proportional
     * to the element position.
     *
     * @param index index of element to return; must be
     *              non-negative and less than the size of this list
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= this.size()})
     */
    E get(int index);
}

// doc comments should be readable both in the source code and in the
// generated documentation.
// o two members or constructors in a class or interface should have
// the same summary description.

/**
 * A college degree, such as B.S., {@literal M.S.} or Ph.D.
 */
class Degree {
}

// When documenting a generic type or method, be sure to document all type parameters:
enum OrchestraSection {
    /**
     * Woodwinds, such as flute, clarinet, and oboe.
     */
    WOODWIND,
    /**
     * Brass instruments, such as french horn and trumpet.
     */
    BRASS,
    /**
     * Percussion instruments, such as timpani and cymbals.
     */
    PERCUSSION,
    /**
     * Stringed instruments, such as violin and cello.
     */
    STRING;
}
// When documenting an annotation type, be sure to document any members
/**
 * Indicates that the annotated method is a test method that
 * must throw the designated exception to pass.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTest {
    /**
     * The exception that the annotated test method must throw
     * in order to pass. (The test is permitted to throw any
     * subtype of the type described by this class object.)
     */
    Class<? extends Throwable> value();
}

//@param	Describes a method parameter.
//@return	Describes the return value of a method.
//@throws	Documents exceptions thrown by a method.
//@see	Adds references to related classes or methods.
//@since	Indicates the version when the API was added.
//@deprecated	Marks an API as deprecated and suggests alternatives.
//@implSpec	Documents implementation-specific behavior (introduced in Java 8).
//@implNote	Provides additional notes about the implementation (introduced in Java 8).