package day06_algorithms_runtime_analysis_and_big_o_notations;

public class FibonacciComparison {

    // Recursive Fibonacci (O(2^n))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N))
    public static int fibonacciIterative(int n) {
        if (n == 0) return 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Test cases for Fibonacci numbers

        System.out.println("Comparative Analysis of Recursive vs Iterative Fibonacci Computation:\n");

        for (int n : testCases) {
            System.out.println("Fibonacci Number: " + n);

            // Measure Recursive Time
            long startRecursive = System.nanoTime();
            try {
                int recursiveResult = fibonacciRecursive(n);
                long endRecursive = System.nanoTime();
                System.out.println("Recursive Result: " + recursiveResult + ", Time: " + (endRecursive - startRecursive) / 1_000_000.0 + " ms");
            } catch (StackOverflowError e) {
                System.out.println("Recursive Result: Infeasible (StackOverflow)");
            }

            // Measure Iterative Time
            long startIterative = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long endIterative = System.nanoTime();
            System.out.println("Iterative Result: " + iterativeResult + ", Time: " + (endIterative - startIterative) / 1_000_000.0 + " ms");

            System.out.println("---------------------------------------");
        }
    }
}
