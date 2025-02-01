package Day03_Sortings_Algorithm;

public class QuickSort {
        // Method to sort an array using Quick Sort
        public static void quickSort(int[] prices, int low, int high) {
            if (low < high) {
                // Partition the array and get the pivot index
                int pivotIndex = partition(prices, low, high);
                // Recursively apply Quick Sort on the left partition
                quickSort(prices, low, pivotIndex - 1);
                // Recursively apply Quick Sort on the right partition
                quickSort(prices, pivotIndex + 1, high);
            }
        }

        // Method to partition the array and return the pivot index
        private static int partition(int[] prices, int low, int high) {
            // Choose the pivot element (here, we choose the last element)
            int pivot = prices[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                // If the current element is smaller than or equal to the pivot
                if (prices[j] <= pivot) {
                    i++;
                    // Swap prices[i] and prices[j]
                    int temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                }
            }

            // Swap prices[i + 1] and prices[high] (or pivot)
            int temp = prices[i + 1];
            prices[i + 1] = prices[high];
            prices[high] = temp;

            return i + 1;
        }

        // Main method to test the Quick Sort implementation
        public static void main(String[] args) {
            int[] prices = {120, 45, 68, 250, 176, 75, 90};
            int n = prices.length;

            System.out.println("Original prices:");
            for (int price : prices) {
                System.out.print(price + " ");
            }

            quickSort(prices, 0, n - 1);

            System.out.println("Sorted prices:");
            for (int price : prices) {
                System.out.print(price + " ");
            }
        }
    }
