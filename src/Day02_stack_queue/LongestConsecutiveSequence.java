package Day02_stack_queue;

// Longest Consecutive Sequence in an Array
import java.util.HashSet;

public class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive sequence
    public static int findLongestConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // Set to store unique elements

        // Add all elements to the set
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Traverse the array
        for (int num : nums) {
            // Check if the current number is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        // Find the length of the longest consecutive sequence
        int result = findLongestConsecutiveSequence(nums);

        // Display the result
        System.out.println("Length of the longest consecutive sequence: " + result);
    }
}
