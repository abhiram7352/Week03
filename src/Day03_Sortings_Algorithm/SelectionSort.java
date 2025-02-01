package Day03_Sortings_Algorithm;

    public class SelectionSort {

        // Method to sort an array using Selection Sort
        public static void selectionSort(int[] scores) {
            int n = scores.length;

            // Move the boundary of the unsorted subarray
            for (int i = 0; i < n - 1; i++) {
                // Find the minimum element in the unsorted subarray
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (scores[j] < scores[minIndex]) {
                        minIndex = j;
                    }
                }

                // Swap the found minimum element with the first element
                int temp = scores[minIndex];
                scores[minIndex] = scores[i];
                scores[i] = temp;
            }
        }

        // Main method to test the Selection Sort implementation
        public static void main(String[] args) {
            int[] scores = {85, 62, 78, 90, 55, 73, 88};
            System.out.println("Original scores:");
            for (int score : scores) {
                System.out.print(score + " ");
            }

            selectionSort(scores);

            System.out.println("\nSorted scores:");
            for (int score : scores) {
                System.out.print(score + " ");
            }
        }
    }