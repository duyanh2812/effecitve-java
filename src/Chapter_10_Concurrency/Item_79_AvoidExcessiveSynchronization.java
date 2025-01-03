package Chapter_10_Concurrency;

import java.util.Set;

@FunctionalInterface
interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(E element);
}

public class Item_79_AvoidExcessiveSynchronization<E> {
    /*
     * To avoid liveness and safety failures, never cede control to the client within
     * a synchronized method or block
     */
    private void notifyElementAdded(E element, Set<SetObserver<E>> observers) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers)
                observer.added(element);
        }
    }

    /*
     * As a rule, you should do as little work as possible inside synchronized regions.
     * Keep synchronized regions small to minimize lock contention and avoid performance bottlenecks.
     * Only synchronize critical sections that modify shared mutable state, and perform other tasks outside the synchronized block.
     * Minimize the duration of locks to allow other threads to access shared resources and improve scalability.
     * Avoid I/O or time-consuming operations inside synchronized blocks, as they can unnecessarily block other threads.
     */
}
