package Day03_Sortings_Algorithm;

import java.util.Arrays;

public class MergeSort {

    // Method to perform merge Sort on an array of Book price
    static int[] sortUsingMerge(int[] bookPrice) {
        // If the array has only one element, it's already sorted
        if (bookPrice.length <= 1) {
            return bookPrice;
        }

        // Find the middle of the array to divide it into two halves
        int mid = bookPrice.length / 2;

        // Recursively divide the array into two halves
        int[] left = Arrays.copyOfRange(bookPrice, 0, mid);  // Left half
        int[] right = Arrays.copyOfRange(bookPrice, mid, bookPrice.length);  // Right half

        // Sort both halves
        left = sortUsingMerge(left);
        right = sortUsingMerge(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Helper method to merge two sorted arrays
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Compare elements from both arrays and put the smaller one in the result
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // If there are remaining elements in the left array, add them to result
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // If there are remaining elements in the right array, add them to result
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Initial array of bookPrice
        int[] bookPrice = {23, 43, 1, 2, 3, 4, 9, 5, 12, 89};

        // Print the original price array
        System.out.println("Original book Price: " + Arrays.toString(bookPrice));

        // Sort using Merge Sort
        int[] sortedBookPrice = sortUsingMerge(bookPrice);

        // Print the sorted bookPrice array
        System.out.println("Sorted book Price: " + Arrays.toString(sortedBookPrice));
    }
}
