package Chapter_10_Concurrency;

/*
 * When many threads are runnable, the thread scheduler determines which ones
 * get to run and for how long. Any reasonable operating system will try to make this
 * determination fairly, but the policy can vary. Therefore, well-written programs shouldn’t
 * depend on the details of this policy. Any program that relies on the thread scheduler for
 * correctness or performance is likely to be nonportable.
 */

/*
 * When faced with a program that barely works because some threads aren’t getting enough
 * CPU time relative to others, resist the temptation to “fix” the program by putting in
 * calls to Thread.yield.
 */
/*
 * Threads should not run if they aren’t doing useful work.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Avoid Timing-Based Code:
 * <p>
 * Do not use Thread.sleep() or other timing mechanisms to synchronize threads. The thread scheduler may not resume threads exactly when you expect, leading to unpredictable behavior.
 * If you need to control the timing or order of thread execution, use higher-level concurrency mechanisms like CountDownLatch, CyclicBarrier, or Semaphore.
 * Use Concurrency Utilities:
 * <p>
 * Use utilities from java.util.concurrent like ExecutorService, CountDownLatch, Semaphore, ReentrantLock, and Atomic variables to manage thread coordination and synchronization. These utilities provide more predictable and reliable ways to control thread execution.
 * Design for Thread Safety:
 * <p>
 * Ensure that your code does not depend on the specific execution order of threads. Instead, design it to be thread-safe by using synchronization, atomic operations, or other concurrency mechanisms.
 * This ensures that your program will work consistently across different systems, JVMs, and hardware configurations.
 * Avoid Assumptions About Thread Scheduling:
 * <p>
 * Do not assume that a thread will always be scheduled immediately after it is started, or that threads will execute in a specific order. This can lead to bugs that are difficult to reproduce and fix.
 * Instead, use synchronization techniques to ensure that threads execute in the desired order or that shared resources are accessed safely.
 */

/*
 * When faced with a program that barely works because some threads aren’t getting enough
 * CPU time relative to others, resist the temptation to “fix” the program by putting in
 * calls to Thread.yield.
 */
public class Item_84_DontDependOnTheThreadScheduler {

    private static int sharedValue = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Use a CountDownLatch to ensure thread1 completes before thread2 starts
        CountDownLatch latch = new CountDownLatch(1);

        executor.submit(() -> {
            sharedValue = 1;
            latch.countDown(); // Signal that thread1 has finished
        });

        executor.submit(() -> {
            try {
                latch.await(); // Wait for thread1 to finish
                if (sharedValue == 1) {
                    System.out.println("Thread 2 sees sharedValue as 1");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }

}
