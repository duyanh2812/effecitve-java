package Chapter_3_ClassesAndInterfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*
To summarize, inheritance is powerful, but it is problematic because it violates
encapsulation. It is appropriate only when a genuine subtype relationship exists
between the subclass and the superclass. Even then, inheritance may lead to
fragility if the subclass is in a different package from the superclass and the
superclass is not designed for inheritance. To avoid this fragility, use
composition and forwarding instead of inheritance, especially if an appropriate
interface to implement a wrapper class exists. Not only are wrapper classes more
robust than subclasses, they are also more powerful.
 */
public class Item_18_FavorCompositionOverInheritance {
}

class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;

    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    public void clear() {
        s.clear();
    }

    public boolean contains(Object o) {
        return s.contains(o);
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }

    public int size() {
        return s.size();
    }

    public Iterator<E> iterator() {
        return s.iterator();
    }

    public boolean add(E e) {
        return s.add(e);
    }

    public boolean remove(Object o) {
        return s.remove(o);
    }

    public boolean containsAll(Collection<?> c) {
        return s.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return s.addAll(c);
    }

    public boolean removeAll(Collection<?> c) {
        return s.removeAll(c);
    }

    public boolean retainAll(Collection<?> c) {
        return s.retainAll(c);
    }

    public Object[] toArray() {
        return s.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return s.toArray(a);
    }

    @Override
    public boolean equals(Object o) {
        return s.equals(o);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s.toString();
    }
}