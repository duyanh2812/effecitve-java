package Chapter_10_Concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * In Java 7, the Executor Framework was extended to support fork-join tasks, which are run by
 * a special kind of executor service known as a fork-join pool. A fork-join task, represented
 * by a ForkJoinTask instance, may be split up into smaller subtasks, and the threads comprising
 * a ForkJoinPool not only process these tasks but “steal” tasks from one another to ensure that
 * all threads remain busy, resulting in higher CPU utilization, higher throughput, and lower
 * latency. Writing and tuning fork-join tasks is tricky. Parallel streams (Item 48) are written
 * atop fork join pools and allow you to take advantage of their performance benefits with little
 * effort, assuming they are appropriate for the task at hand.
 */
public class Item_80_PreferExecutorsTasksAndStreamsToThreads {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool with 4 threads
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor
        Callable<Integer> task1 = () -> {
            System.out.println("Task 1 is running");
            return 1;
        };
        Callable<Integer> task2 = () -> {
            System.out.println("Task 2 is running");
            return 2;
        };

        Future<Integer> future1 = executorService.submit(task1);
        Future<Integer> future2 = executorService.submit(task2);

        // Get the results from the tasks
        System.out.println(STR."Result of task 1: \{future1.get()}");
        System.out.println(STR."Result of task 2: \{future2.get()}");

        // Shutdown the executor
        executorService.shutdown();

        // 2. Parallel Stream
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Use a parallel stream to process the list in parallel
        int sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of numbers: " + sum);

        //3. Using ExecutorService with Runnable:

        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        Runnable task3 = () -> System.out.println("Task 1 is running");
        Runnable task4 = () -> System.out.println("Task 2 is running");

        // Submit tasks to the executor
        executorService2.submit(task3);
        executorService2.submit(task4);

        // Shutdown the executor
        executorService2.shutdown();


    }

}
