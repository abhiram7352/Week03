package day05_StringBuilder_StringBuffer_FileReader_InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearAndBinarySearch {

    public static void main(String[] args) {
        // Test data: list of integers

        int[] nums = {3, 4, -1, 1};
        int target = 4; // Target number for binary search

        // Task 1: Finding the first missing positive integer using Linear Search
        int firstMissingPositive = findFirstMissingPositive(nums);
        System.out.println("The first missing positive integer is: " + firstMissingPositive);

        // Task 2: Finding the index of the target using Binary Search
        int index = binarySearch(nums, target);
        if (index != -1) {
            System.out.println("The index of target " + target + " is: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }

    // Task 1: Linear Search for the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace all negative numbers and zeros with a value greater than the length of the array
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1; // Use a number that is out of bounds
            }
        }

        // Step 2: Use the index of the array to mark the presence of elements
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark the index as visited (negative marking)
            }
        }

        // Step 3: Find the first index that is positive, meaning the corresponding number is missing
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // The missing positive number is i+1
            }
        }

        // Step 4: If no positive index is found, return n+1 as the first missing positive
        return n + 1;
    }

    // Task 2: Binary Search to find the index of the target number
    public static int binarySearch(int[] nums, int target) {
        // Sort the array first (Binary Search requires sorted array)
        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        // Perform binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (nums[mid] == target) {
                return mid; // Target found, return its index
            }

            // If target is greater, ignore the left half
            if (nums[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // Target is not found
        return -1;
    }
}
