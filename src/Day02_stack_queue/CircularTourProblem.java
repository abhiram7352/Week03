package Day02_stack_queue;

// Circular Tour Problem in Java
import java.util.Queue;
import java.util.LinkedList;

public class CircularTourProblem {

    // Class to represent a petrol pump
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Method to find the starting point of the circular tour
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0; // Starting point
        int surplus = 0; // Surplus petrol
        int deficit = 0; // Deficit petrol

        // Traverse through all petrol pumps
        for (int i = 0; i < n; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;

            // If surplus becomes negative, move the start to the next pump
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        // Check if the total petrol is enough to cover the total distance
        return (surplus + deficit >= 0) ? start : -1;
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };

        // Find the starting point
        int start = findStartingPoint(pumps);

        // Display the result
        if (start != -1) {
            System.out.println("Start at petrol pump: " + start);
        } else {
            System.out.println("No solution exists");
        }
    }
}
