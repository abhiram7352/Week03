package Day03_Sortings_Algorithm;

import java.util.Arrays;

public class InsertionSort {

    // Method to perform Insertion Sort on an array of employee IDs
    static int[] sortEmployeeId(int[] employeeId){
        // Get the size of the employeeId array
        int size = employeeId.length;

        // Loop through the array starting from the second element
        for(int i=1; i<size; i++){
            // Store the current element (key) to be inserted
            int key = employeeId[i];
            // The index for comparison (start from the element before key)
            int j = i-1;

            // Shift elements that are greater than the key to one position ahead
            while(j>=0 && employeeId[j]>key){
                // Move element to the right
                employeeId[j+1] = employeeId[j];
                // Move to the next element in the array
                j--;
            }
            // Insert the key element at its correct position
            employeeId[j+1] = key;
        }
        // Return the sorted array
        return employeeId;
    }

    public static void main(String[] args) {
        // Initial array of employee IDs
        int[] employeeId = {23, 43, 1, 2, 3, 4, 9, 5, 12, 89};

        // Print the original employee ID array
        System.out.println("Original employeeID: "+Arrays.toString(employeeId));

        // Sort the employee IDs using Insertion Sort
        int[] sortedEmployeeId = sortEmployeeId(employeeId);

        // Print the sorted employee ID array
        System.out.println("Sorted employeeID: "+ Arrays.toString(sortedEmployeeId));
    }
}
