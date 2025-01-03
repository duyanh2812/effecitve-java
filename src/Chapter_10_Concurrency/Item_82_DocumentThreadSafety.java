package Chapter_10_Concurrency;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * To enable safe concurrent use, a class must clearly document what level of thread safety it supports.
 *
 * 1. Immutable—Instances of this class appear constant. No external synchronization is necessary.
 * Examples include String, Long, and BigInteger
 *
 * 2. Unconditionally thread-safe—Instances of this class are mutable, but the class has sufficient
 * internal synchronization that its instances can be used concurrently without the need for any
 * external synchronization. Examples include AtomicLong and ConcurrentHashMap.
 *
 * 3. Conditionally thread-safe—Like unconditionally thread-safe, except that some methods
 * require external synchronization for safe concurrent use. Examples include the collections
 * returned by the Collections.synchronized wrappers, whose iterators require external
 * synchronization.
 *
 * 4. Not thread-safe—Instances of this class are mutable. To use them concurrently, clients
 * must surround each method invocation (or invocation sequence) with external synchronization
 * of the clients’ choosing. Examples include the general-purpose collection implementations,
 * such as ArrayList and HashMap.
 *
 * 5. Thread-hostile—This class is unsafe for concurrent use even if every method invocation
 * is surrounded by external synchronization. Thread hostility usually results from modifying
 * static data without synchronization. No one writes a thread-hostile class on purpose; such
 * classes typically result from the failure to consider concurrency. When a class or method
 * is found to be thread-hostile, it is typically fixed or deprecated.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ThreadSafe {
}

/**
 * Thread Safe
 */
@ThreadSafe
class ThreadSafeCache {
    private final Map<String, String> cache = new HashMap<>();

    public synchronized void put(String key, String value) {
        cache.put(key, value);
    }

    public synchronized String get(String key) {
        return cache.get(key);
    }
}

public class Item_82_DocumentThreadSafety {
}
