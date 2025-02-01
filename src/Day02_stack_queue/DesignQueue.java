package Day02_stack_queue;

import java.util.Stack;

// Implementation of a queue using two stacks
class DesignQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    // Constructor to initialize the stacks
    public DesignQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Push element into stack1
    public void enqueue(int x) {
        stack1.push(x);
    }

    // Dequeue operation: Transfer elements from stack1 to stack2 if stack2 is empty, then pop from stack2
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stack2.pop();
    }

    // Check if the queue is empty: Return true if both stacks are empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        DesignQueue designQueue = new DesignQueue();
        designQueue.enqueue(5);
        designQueue.enqueue(6);
        designQueue.enqueue(7);


        // Dequeue and display elements
        System.out.println(designQueue.dequeue()); // Output: 5
        //System.out.println(designQueue.peek());    // Output: 6
        System.out.println(designQueue.dequeue()); // Output: 6
        System.out.println(designQueue.dequeue()); // Output: 7


        // Check if the queue is empty
        System.out.println(designQueue.isEmpty()); // Output: true
    }
}
