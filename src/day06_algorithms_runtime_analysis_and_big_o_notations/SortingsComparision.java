package day06_algorithms_runtime_analysis_and_big_o_notations;
import java.util.Arrays;
import java.util.Random;
public class SortingsComparision {
        // Bubble Sort
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        // Merge Sort
        public static void mergeSort(int[] arr) {
            if (arr.length > 1) {
                int mid = arr.length / 2;
                int[] left = Arrays.copyOfRange(arr, 0, mid);
                int[] right = Arrays.copyOfRange(arr, mid, arr.length);

                mergeSort(left);
                mergeSort(right);

                merge(arr, left, right);
            }
        }

        private static void merge(int[] arr, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }

        // Quick Sort
        public static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        // Generate random array
        public static int[] generateArray(int size) {
            Random rand = new Random();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(size);
            }
            return arr;
        }

        // Measure time taken by sorting algorithms
        public static void benchmarkSorting(int size) {
            int[] originalArray = generateArray(size);

            int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
            int[] mergeArray = Arrays.copyOf(originalArray, originalArray.length);
            int[] quickArray = Arrays.copyOf(originalArray, originalArray.length);

            long startTime, endTime;

            // Bubble Sort Timing
            startTime = System.currentTimeMillis();
            bubbleSort(bubbleArray);
            endTime = System.currentTimeMillis();
            System.out.println("Bubble Sort for size " + size + ": " + (endTime - startTime) + " ms");

            // Merge Sort Timing
            startTime = System.currentTimeMillis();
            mergeSort(mergeArray);
            endTime = System.currentTimeMillis();
            System.out.println("Merge Sort for size " + size + ": " + (endTime - startTime) + " ms");

            // Quick Sort Timing
            startTime = System.currentTimeMillis();
            quickSort(quickArray, 0, quickArray.length - 1);
            endTime = System.currentTimeMillis();
            System.out.println("Quick Sort for size " + size + ": " + (endTime - startTime) + " ms");

            System.out.println("-------------------------------------------");
        }

        public static void main(String[] args) {
            int[] sizes = {1000, 10000, 1000000};
            for (int size : sizes) {
                benchmarkSorting(size);
            }
        }
    }

