package CreateAndDestroyObject;

import java.util.EmptyStackException;

/*
Memory leaks in garbage-collected languages (more properly known as
unintentional object retentions) are insidious. If an object reference is
unintentionally retained, not only is that object excluded from garbage
collection, but so too are any objects referenced by that object, and so on. Even
if only a few object references are unintentionally retained, many, many objects
may be prevented from being garbage collected, with potentially large effects on
performance.
The fix for this sort of problem is simple: null out references once they
become obsolete.
 */
public class EliminateObsoleteReference {
    private int size;
    private EliminateObsoleteReference[] elements = {};

    public static void main(String[] args) {

    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
}
