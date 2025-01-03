package Chapter_10_Concurrency;

/*
 * In summary, using wait and notify directly is like programming in “concurrency assembly
 * language,” as compared to the higher-level language provided by java.util.concurrent.
 * There is seldom, if ever, a reason to use wait and notify in new code. If you maintain
 * code that uses wait and notify, make sure that it always invokes wait from within a while
 * loop using the standard idiom. The notifyAll method should generally be used in preference
 * to notify. If notify is used, great care must be taken to ensure liveness.
 */

/*
 * Prefer concurrency utilities (e.g., ExecutorService, BlockingQueue, ReentrantLock, Condition, Semaphore) over low-level synchronization mechanisms like wait() and notify().
 * Concurrency utilities provide higher-level abstractions that are easier to use, more flexible, and less error-prone.
 * These utilities manage thread synchronization and blocking for you, simplifying the code and improving maintainability and performance.
 */

/*
 * When You Need to Handle Complex Synchronization:
 * <p>
 * If your synchronization logic involves multiple threads waiting for different conditions
 * or needs more advanced features like timed locks or lock fairness, prefer using ReentrantLock
 *  and Condition.
 * When You Need to Handle Blocking Operations:
 * <p>
 * Use BlockingQueue, Semaphore, or CountDownLatch when you need to block threads efficiently
 *  without manually managing locks.
 * When You Need Scalability and Performance:
 * <p>
 * Concurrency utilities like ExecutorService and ForkJoinPool provide better scalability
 *  and performance than manually managing threads.
 * When You Want Simpler and More Maintainable Code:
 * <p>
 * The higher-level concurrency utilities are easier to use and less error-prone than using
 * wait() and notify(), especially in complex scenarios.
 */

// 1. Using Condition with ReentrantLock:

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.*;

class SharedResource {
    private int data;
    private boolean available = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void produce(int data) throws InterruptedException {
        lock.lock();
        try {
            while (available) {
                condition.await(); // Wait until the consumer consumes the data
            }
            this.data = data;
            available = true;
            condition.signal(); // Notify the consumer that data is available
        } finally {
            lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        lock.lock();
        try {
            while (!available) {
                condition.await(); // Wait until the producer produces data
            }
            available = false;
            condition.signal(); // Notify the producer that data has been consumed
            return data;
        } finally {
            lock.unlock();
        }
    }
}
// 2. Using BlockingQueue (Concurrency Utility):

class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                int data = 1;
                while (true) {
                    queue.put(data); // Block until space is available
                    System.out.println("Produced: " + data);
                    data++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int data = queue.take(); // Block until data is available
                    System.out.println("Consumed: " + data);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

// 3. Using wait() and notify() (Traditional Approach):
class SharedResource2 {
    private int data;
    private boolean available = false;

    public synchronized void produce(int data) throws InterruptedException {
        while (available) {
            wait(); // Wait until the consumer consumes the data
        }
        this.data = data;
        available = true;
        notifyAll(); // Notify the consumer that data is available
    }

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait(); // Wait until the producer produces data
        }
        available = false;
        notifyAll(); // Notify the producer that data has been consumed
        return data;
    }
}


public class Item_81_PreferConcurrencyUtilitiesToWaitAndNotify {
}
