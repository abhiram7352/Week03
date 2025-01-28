package Day01_linkedlist;

// Node class representing a task
class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    // Constructor
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List class for Task Scheduler
class TaskScheduler {
    private TaskNode head;
    private TaskNode tail;

    // Constructor
    public TaskScheduler() {
        this.head = null;
        this.tail = null;
    }

    // Add a task at the beginning of the circular list
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            // If the list is empty, make the new node the head and tail, and point it to itself
            head = tail = newNode;
            newNode.next = head;
        } else {
            // Insert the new node at the beginning and update the tail's next pointer
            newNode.next = head;
            head = newNode;
            tail.next = head; // Maintain circularity
        }
        System.out.println("Task added at the beginning: " + taskName);
    }

    // Add a task at the end of the circular list
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        if (head == null) {
            // If the list is empty, make the new node the head and tail, and point it to itself
            head = tail = newNode;
            newNode.next = head;
        } else {
            // Insert the new node at the end and update the tail's next pointer
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circularity
        }
        System.out.println("Task added at the end: " + taskName);
    }

    // Add a task at a specific position in the circular list
    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            // If position is 1, add at the beginning
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
            if (current == head) {
                // If we loop back to the head, the position exceeds the list size
                System.out.println("Position exceeds the length of the list. Task added at the end.");
                addTaskAtEnd(taskId, taskName, priority, dueDate);
                return;
            }
        }
        // Insert the new node at the specified position
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Task added at position " + position + ": " + taskName);
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("List is empty. No task to remove.");
            return;
        }
        TaskNode current = head;
        TaskNode prev = tail; // Start with tail as the previous node
        boolean found = false;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    // If the task to remove is the head, update the head
                    head = head.next;
                    tail.next = head; // Maintain circularity
                } else if (current == tail) {
                    // If the task to remove is the tail, update the tail
                    tail = prev;
                    tail.next = head; // Maintain circularity
                } else {
                    // Remove the task from the middle
                    prev.next = current.next;
                }
                System.out.println("Task removed: " + current.taskName);
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head); // Traverse the circular list
        if (!found) {
            System.out.println("Task not found with ID: " + taskId);
        }
    }

    // View the current task and move to the next task
    public void viewCurrentAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current Task: " + head.taskName + " (ID: " + head.taskId + ")");
        head = head.next; // Move to the next task
    }

    // Display all tasks in the circular list
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        TaskNode current = head;
        System.out.println("Tasks in the list:");
        do {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head); // Traverse the circular list
    }

    // Search for tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        TaskNode current = head;
        boolean found = false;
        System.out.println("Tasks with priority " + priority + ":");
        do {
            if (current.priority == priority) {
                System.out.println("ID: " + current.taskId + ", Name: " + current.taskName + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head); // Traverse the circular list
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }
}

// Main class to test the Task Scheduler
public class ListTaskScheduler {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addTaskAtBeginning(1, "Complete Project", 1, "2023-10-15");
        scheduler.addTaskAtEnd(2, "Prepare Presentation", 2, "2023-10-20");
        scheduler.addTaskAtPosition(3, "Review Code", 3, "2023-10-18", 2);

        // Display all tasks
        scheduler.displayAllTasks();

        // Search tasks by priority
        scheduler.searchByPriority(2);

        // View current task and move to the next task
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();

        // Remove a task by ID
        scheduler.removeTaskById(2);

        // Display all tasks after removal
        scheduler.displayAllTasks();
    }
}