package class2recursion1binarysearch;

public class FibonacciNumber {
    public long fibonacci(int K) {
        // Write your solution here
        if (K < 0 || K == 0) {
            return 0;
        } else if (K == 1) {
            return 1;
        }
        long first = 0;
        long second = 1;
        for (int i = 2; i <= K; i++) {
            long temp = second;
            second += first;
            first = temp;
        }
        return second;
    }
}
