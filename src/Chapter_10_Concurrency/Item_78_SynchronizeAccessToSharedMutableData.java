package Chapter_10_Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronize access to shared mutable data to avoid race conditions and ensure thread safety.
 * Use the synchronized keyword for methods or blocks, or use ReentrantLock for more fine-grained control over locking.
 * Be cautious when synchronizing, as improper synchronization can lead to deadlocks or performance issues.
 * Avoid synchronization for immutable data or when using thread-safe libraries that handle synchronization internally.
 */
public class Item_78_SynchronizeAccessToSharedMutableData {

}

// Cooperative thread termination with a volatile field
class StopThread {
    private static volatile boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

    // Lock-free synchronization with java.util.concurrent.atomic
    private static final AtomicLong nextSerialNum = new AtomicLong();

    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }
}

// 1. Synchronizing Methods:
class Counter {
    private int count = 0;

    // Synchronized method to ensure thread-safe access
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

// 2. Synchronizing Blocks:
class Counter2 {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }
}

// Using ReentrantLock:
class Counter3 {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();  // Acquiring the lock
        try {
            count++;
        } finally {
            lock.unlock();  // Ensuring the lock is released
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}


