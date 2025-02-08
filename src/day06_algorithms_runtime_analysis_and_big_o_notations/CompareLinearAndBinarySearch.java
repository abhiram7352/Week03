package day06_algorithms_runtime_analysis_and_big_o_notations;
import java.util.Arrays;
import java.util.Random;

public class CompareLinearAndBinarySearch {

        // Linear Search Algorithm
        public static int linearSearch(int[] arr, int target) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == target) {
                    return i; // Target found
                }
            }
            return -1; // Target not found
        }

        // Binary Search Algorithm
        public static int binarySearch(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) {
                    return mid; // Target found
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1; // Target not found
        }

        public static void main(String[] args) {
            int[] datasetSizes = {1000, 10000, 1000000};
            Random rand = new Random();
            int target = -1; // Ensure worst-case scenario where target is not found

            for (int size : datasetSizes) {
                int[] data = new int[size];
                for (int i = 0; i < size; i++) {
                    data[i] = rand.nextInt(size * 10); // Random data
                }

                // Linear Search Performance
                long startTime = System.nanoTime();
                linearSearch(data, target);
                long endTime = System.nanoTime();
                long linearDuration = (endTime - startTime) / 1000000; // Convert to milliseconds

                // Binary Search Performance
                Arrays.sort(data); // O(N log N)
                startTime = System.nanoTime();
                binarySearch(data, target);
                endTime = System.nanoTime();
                long binaryDuration = (endTime - startTime) / 1000000; // Convert to milliseconds

                // Output Results
                System.out.println("Dataset Size: " + size);
                System.out.println("Linear Search Time: " + linearDuration + " ms");
                System.out.println("Binary Search Time: " + binaryDuration + " ms");
                System.out.println("----------------------------");
            }
        }
    }

