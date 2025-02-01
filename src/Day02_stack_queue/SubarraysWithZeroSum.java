package Day02_stack_queue;
// Find All Subarrays with Zero Sum in Java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraysWithZeroSum {

    // Method to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int cumulativeSum = 0;

        // Initialize the map with a sum of 0 at index -1
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before
            if (map.containsKey(cumulativeSum)) {
                // Get all starting indices for this sum
                for (int startIndex : map.get(cumulativeSum)) {
                    // Add the subarray [startIndex + 1, i] to the result
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            // Add the current index to the list for this sum
            map.putIfAbsent(cumulativeSum, new ArrayList<>());
            map.get(cumulativeSum).add(i);
        }

        return result;
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -1, -3, 4, -6, 6};

        // Find all subarrays with zero sum
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Display the result
        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println("Start: " + subarray[0] + ", End: " + subarray[1]);
        }
    }
}
