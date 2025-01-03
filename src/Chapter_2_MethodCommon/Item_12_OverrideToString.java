package Chapter_2_MethodCommon;

/*
providing a good toString implementation makes your
class much more pleasant to use and makes systems using the class easier to
debug. The toString method is automatically invoked when an object is
passed to println, printf, the string concatenation operator, or assert, or
is printed by a debugger. Even if you never call toString on an object, others
may. For example, a component that has a reference to your object may include
the string representation of the object in a logged error message. If you fail to
override toString, the message may be all but useless.

override Object’s toString implementation in every
instantiable class you write, unless a superclass has already done so. It makes
classes much more pleasant to use and aids in debugging. The toString
method should return a concise, useful description of the object, in an
aesthetically pleasing format

 */
public class Item_12_OverrideToString {
    private Short areaCode;
    private Short prefix;
    private Short lineNum;

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }
}
