package Day03_Sortings_Algorithm;

public class HeapSort {

    // Method to sort an array using Heap Sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap from the array
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Call max heapify on the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify a subtree rooted at index i
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(salaries, n, largest);
        }
    }

    // Main method to test the Heap Sort implementation
    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 60000, 80000, 55000, 65000, 75000};
        System.out.println("Original salaries:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

        heapSort(salaries);

        System.out.println("\nSorted salaries:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}