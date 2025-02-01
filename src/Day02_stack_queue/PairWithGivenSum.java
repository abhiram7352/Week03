package Day02_stack_queue;

// Check for a Pair with Given Sum in an Array
import java.util.HashSet;

public class PairWithGivenSum {

    // Method to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int targetSum) {
        HashSet<Integer> seen = new HashSet<>(); // Set to store visited numbers

        // Traverse the array
        for (int num : arr) {
            // Check if targetSum - num exists in the set
            if (seen.contains(targetSum - num)) {
                return true; // Pair found
            }

            // Add the current number to the set
            seen.add(num);
        }

        return false; // No pair found
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int targetSum = 17;

        // Check if a pair with the given sum exists
        boolean result = hasPairWithSum(arr, targetSum);

        // Display the result
        if (result) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum exists.");
        }
    }
}
