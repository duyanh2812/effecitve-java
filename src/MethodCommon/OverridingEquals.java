package MethodCommon;

/*
when is it appropriate to override equals? It is when a class has a notion
of logical equality that differs from mere object identity and a superclass has not
already overridden equals. This is generally the case for value classes. A value
class is simply a class that represents a value, such as Integer or String

The equals method implements an equivalence relation. It has these
properties:
• Reflexive: For any non-null reference value x, x.equals(x) must return
true.
• Symmetric: For any non-null reference values x and y, x.equals(y)must return true if and only if y.equals(x) returns true.
• Transitive: For any non-null reference values x, y, z, if x.equals(y)
returns true and y.equals(z) returns true, then x.equals(z)
must return true.
• Consistent: For any non-null reference values x and y, multiple invocations
of x.equals(y) must consistently return true or consistently return
false, provided no information used in equals comparisons is
modified.
• For any non-null reference value x, x.equals(null) must return
false.

1. Always override hashCode when you override equals
2. Don’t try to be too clever. If you simply test fields for equality, it’s not hard
to adhere to the equals contract.
3. Don’t substitute another type for Object in the equals declaration.
 */
public class OverridingEquals {
}
