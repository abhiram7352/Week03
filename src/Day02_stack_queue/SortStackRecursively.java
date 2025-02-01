package Day02_stack_queue;

// Sorting a Stack Using Recursion in Java
import java.util.Stack;
public class SortStackRecursively {

    // Method to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        // Base case: if the stack has 0 or 1 element, it is already sorted
        if (stack.isEmpty() || stack.size() == 1) {
            return;
        }
        // Remove the top element of the stack
        int top = stack.pop();

        // Sort the remaining stack
        sortStack(stack);

        // Insert the popped element back in the sorted stack
        insertInSortedOrder(stack, top);
    }

    // Helper method to insert an element in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Base case: if the stack is empty or the top element is smaller than or equal to the value
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively insert the value in the sorted stack
        insertInSortedOrder(stack, value);

        // Push the top element back after inserting the value
        stack.push(top);
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Add elements to the stack
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        // Display the original stack
        System.out.println("Original Stack: " + stack);

        // Sort the stack
        sortStack(stack);

        // Display the sorted stack
        System.out.println("Sorted Stack: " + stack);
    }
}
