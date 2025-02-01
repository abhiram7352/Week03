package Day02_stack_queue;

// Two Sum Problem Implementation in Java
import java.util.HashMap;

public class TwoSumProblem {

    // Method to find two indices such that their values add up to the target
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // Map to store value and index

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return indices
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }

        return new int[0]; // Return empty array if no solution is found
    }

    // Main method for testing the TwoSumProblem
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Find indices of the two numbers
        int[] result = twoSum(nums, target);

        // Display the result
        if (result.length == 2) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}
