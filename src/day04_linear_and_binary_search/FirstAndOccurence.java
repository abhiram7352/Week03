package day04_linear_and_binary_search;

import java.sql.PreparedStatement;

public class FirstAndOccurence {

    // Method to find the first occurrence of the target element using binary search
    // Arguments: int[] ar (array), int left (starting index), int right (ending index), int target (element to find)
    public static int firstOccurence(int[] ar, int left, int right, int target){
        int result = -1;   // -1 if element not found)

        // Perform binary search to find the first occurrence
        while (left <= right){
            // Calculate middle index
            int mid = left + (right - left) / 2;

            if(ar[mid] == target){
                result = mid;   // Target found, store the index
                right = mid - 1; // Continue searching on the left half to find the first occurrence
            } else if (ar[mid] < target){
                left = mid + 1; // Target is on the right half
            } else {
                right = mid - 1; // Target is on the left half
            }
        }
        return result; // Return the index of the first occurrence or -1 if not found
    }

    // Method to find the last occurrence of the target element using binary search
    // Arguments: int[] ar (array), int left (starting index), int right (ending index), int target (element to find)
    public static int lastOccurence(int[] ar, int left, int right, int target){
        int result = -1;  // -1 if lement not found)

        // Perform binary search to find the last occurrence
        while (left <= right){
            // Calculate middle index
            int mid = left + (right - left) / 2;

            if(ar[mid] == target){
                result = mid;   // Target found, store the index
                left = mid + 1; // Continue searching on the right half to find the last occurrence
            } else if (ar[mid] < target){
                left = mid + 1; // Target is on the right half
            } else {
                right = mid - 1; // Target is on the left half
            }
        }
        return result; // Return the index of the last occurrence or -1 if not found
    }

    public static void main(String[] args) {
        // Sample sorted array and target value to find
        int[] element = {1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5};
        int target = 3; // The target value to search for

        int left = 0;
        int right = element.length - 1;

        // Call the methods to find the first and last occurrences of the target
        int first = firstOccurence(element, left, right, target);
        int last = lastOccurence(element, left, right, target);

        // Print the results for the first and last occurrences
        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
    }
}
