package day06_algorithms_runtime_analysis_and_big_o_notations;
public class StringConcatenationPerformance {

    // Concatenate using String (Immutable, inefficient for large operations)
    public static long concatenateWithString(int n) {
        long startTime = System.currentTimeMillis(); // Record start time
        String result = ""; // Initialize empty string
        for (int i = 0; i < n; i++) {
            result += "a"; // Concatenate by creating new string each time
        }
        long endTime = System.currentTimeMillis(); // Record end time
        return endTime - startTime; // Return time taken
    }

    // Concatenate using StringBuilder (Mutable, efficient, not thread-safe)
    public static long concatenateWithStringBuilder(int n) {
        long startTime = System.currentTimeMillis(); // Record start time
        StringBuilder sb = new StringBuilder(); // Initialize StringBuilder
        for (int i = 0; i < n; i++) {
            sb.append("a"); // Append character efficiently
        }
        long endTime = System.currentTimeMillis(); // Record end time
        return endTime - startTime; // Return time taken
    }

    // Concatenate using StringBuffer (Mutable, thread-safe, slightly slower)
    public static long concatenateWithStringBuffer(int n) {
        long startTime = System.currentTimeMillis(); // Record start time
        StringBuffer sb = new StringBuffer(); // Initialize StringBuffer
        for (int i = 0; i < n; i++) {
            sb.append("a"); // Append character with thread-safety
        }
        long endTime = System.currentTimeMillis(); // Record end time
        return endTime - startTime; // Return time taken
    }

    // Benchmark the performance of different string concatenation methods
    public static void benchmarkConcatenation(int n) {
        System.out.println("\nConcatenation for " + n + " operations:");

        // Measure time for String concatenation
        long stringTime = concatenateWithString(n);
        System.out.println("String (Immutable) : " + stringTime + " ms");

        // Measure time for StringBuilder concatenation
        long stringBuilderTime = concatenateWithStringBuilder(n);
        System.out.println("StringBuilder (Mutable, Thread-Unsafe) : " + stringBuilderTime + " ms");

        // Measure time for StringBuffer concatenation
        long stringBufferTime = concatenateWithStringBuffer(n);
        System.out.println("StringBuffer (Mutable, Thread-Safe) : " + stringBufferTime + " ms");

        System.out.println("-------------------------------------------");
    }

    // Main method to run benchmarks for different operation counts
    public static void main(String[] args) {
        int[] operationCounts = {1000, 10000, 1000000}; // Define different operation counts
        for (int n : operationCounts) {
            benchmarkConcatenation(n); // Run benchmark for each count
        }
    }
}
