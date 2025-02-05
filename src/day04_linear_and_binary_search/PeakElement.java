package day04_linear_and_binary_search;

// Class to find a peak element in an array using binary search
public class PeakElement {

    // Method to find a peak element using binary search
    // Arguments: int[] ar (array), int left (starting index), int right (ending index)
    public static  int peakElementUsingBinarySearch(int[] ar, int left, int right){

        // Variable to store the peak element
        int ans = 1;

        // Loop until left index is less than right index
        while (left < right){

            // Calculate the middle index of the current subarray
            int mid = (left + right) / 2;

            // Check if mid element is greater than its neighbors (peak element)
            if(ar[mid] > ar[mid-1] && ar[mid] > ar[mid+1]){
                return ar[mid]; // Return the peak element
            }
            // If the element to the left of mid is greater, search in the left half
            else if(ar[mid] < ar[mid-1]){
                right = mid - 1;
            }
            // Otherwise, search in the right half
            else {
                left = mid + 1;
            }
        }

        // Return the element at the left index when the loop ends
        return ar[left];
    }

    // Main method to test the peak element finding logic
    public static void main(String[] args) {

        // Sample array of integers
        int[] ar = {3, 4, 1, -1, 8, 34, 7};

        // Define the left and right boundaries of the array
        int left = 0;
        int right = ar.length - 1;

        // Call the method to find the peak element
        int peakElement = peakElementUsingBinarySearch(ar, left, right);

        // Print the result (one of the peak elements in the array)
        System.out.println("One of peak element in the array: " + peakElement);
    }
}
