package Chapter_6_LambdasAndStreams;

import java.util.Arrays;
import java.util.List;

/*
 * 1. Use parallel streams when the operation is CPU-bound, stateless, and does not modify
 * shared state.
 * 2. Avoid parallel streams for small datasets, I/O-bound operations,or operations that
 * involve shared mutable state.
 * 3. Always measure and test the performance to ensure that parallelization is beneficial in
 * your specific case.
 */
public class Item_48_UseCautionWhenMakingStreamsParallel {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum); // 55
    }
}
