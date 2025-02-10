package day06_algorithms_runtime_analysis_and_big_o_notations;

import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100_000, 1_000_000}; // Dataset sizes for testing
        Random random = new Random();
        int searchElement = -1; // An element that doesn't exist to simulate worst-case scenario

        System.out.println("Comparative Analysis of Array, HashSet, and TreeSet for Searching:\n");

        for (int size : datasetSizes) {
            System.out.println("Dataset Size: " + size);

            // Generate dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>(size);
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                int num = random.nextInt(size * 10); // Ensure randomness and non-sequential numbers
                array[i] = num;
                hashSet.add(num);
                treeSet.add(num);
            }

            // Array Search (Linear Search - O(N))
            long startArraySearch = System.nanoTime();
            boolean arrayFound = linearSearch(array, searchElement);
            long endArraySearch = System.nanoTime();
            System.out.println("Array Search: Found = " + arrayFound + ", Time = " + (endArraySearch - startArraySearch) / 1_000_000.0 + " ms");

            // HashSet Search (Hashing - O(1))
            long startHashSetSearch = System.nanoTime();
            boolean hashSetFound = hashSet.contains(searchElement);
            long endHashSetSearch = System.nanoTime();
            System.out.println("HashSet Search: Found = " + hashSetFound + ", Time = " + (endHashSetSearch - startHashSetSearch) / 1_000_000.0 + " ms");

            // TreeSet Search (Binary Search Tree - O(log N))
            long startTreeSetSearch = System.nanoTime();
            boolean treeSetFound = treeSet.contains(searchElement);
            long endTreeSetSearch = System.nanoTime();
            System.out.println("TreeSet Search: Found = " + treeSetFound + ", Time = " + (endTreeSetSearch - startTreeSetSearch) / 1_000_000.0 + " ms");

            System.out.println("---------------------------------------");
        }
    }

    // Linear search method for arrays
    private static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
