package Day01_linkedlist;

class TextState {
    String content; // Text content of this state
    TextState prev; // Pointer to the previous state
    TextState next; // Pointer to the next state

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    private TextState head; // Head of the doubly linked list
    private TextState tail; // Tail of the doubly linked list
    private TextState current; // Pointer to the current state
    private final int maxHistory; // Maximum undo/redo history size
    private int size; // Current size of the doubly linked list

    public TextEditor(int maxHistory) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.maxHistory = maxHistory;
        this.size = 0;
    }

    // Add a new text state
    public void addTextState(String content) {
        TextState newState = new TextState(content);

        if (current != null) {
            // Cut off any redo history when a new state is added
            current.next = null;
        }

        if (size == maxHistory) {
            // Remove the oldest state to maintain the maxHistory limit
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }

        if (head == null) {
            // First state in the list
            head = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
        }

        tail = newState;
        current = newState;
        size++;

        System.out.println("Added new state: " + content);
    }

    // Undo functionality
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Undo not possible. No previous state.");
            return;
        }
        current = current.prev;
        System.out.println("Undone. Current state: " + current.content);
    }

    // Redo functionality
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Redo not possible. No next state.");
            return;
        }
        current = current.next;
        System.out.println("Redone. Current state: " + current.content);
    }

    // Display the current state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No current state.");
        } else {
            System.out.println("Current state: " + current.content);
        }
    }

    // Display all states (for debugging or visualization purposes)
    public void displayAllStates() {
        if (head == null) {
            System.out.println("No states available.");
            return;
        }

        System.out.println("All states:");
        TextState temp = head;
        while (temp != null) {
            String marker = (temp == current) ? " <-- Current" : "";
            System.out.println(temp.content + marker);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10); // Limit history to 10 states

        // Simulating user actions
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");

        editor.displayCurrentState(); // Should display "Hello World!"

        editor.undo(); // Undo to "Hello World"
        editor.displayCurrentState(); // Should display "Hello World"

        editor.undo(); // Undo to "Hello"
        editor.displayCurrentState(); // Should display "Hello"

        editor.redo(); // Redo to "Hello World"
        editor.displayCurrentState(); // Should display "Hello World"

        editor.addTextState("Hello Everyone!"); // New state after redo clears redo history
        editor.displayAllStates(); // Display all states

        editor.undo();
        editor.displayCurrentState(); // Should display "Hello World"
    }
}
