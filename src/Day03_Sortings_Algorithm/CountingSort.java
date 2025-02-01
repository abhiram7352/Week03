package Day03_Sortings_Algorithm;

public class CountingSort {

    // Method to sort an array using Counting Sort
    public static void countingSort(int[] ages) {
        int n = ages.length;
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        // Create a count array to store the frequency of each age
        int[] count = new int[range];
        for (int i = 0; i < n; i++) {
            count[ages[i] - minAge]++;
        }

        // Compute cumulative frequencies to determine positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in their correct positions in the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy the sorted elements back to the original array
        for (int i = 0; i < n; i++) {
            ages[i] = output[i];
        }
    }

    // Main method to test the Counting Sort implementation
    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 11, 17, 16, 12};
        System.out.println("Original ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        countingSort(ages);

        System.out.println("\nSorted ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
