package Day01_linkedlist;

class ProcessNode {
    int processID; // Unique ID of the process
    int burstTime; // Burst Time of the process
    int priority; // Priority of the process (not used in round-robin but can be extended later)
    ProcessNode next; // Pointer to the next process

    ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private ProcessNode head = null; // Head of the circular linked list
    private ProcessNode tail = null; // Tail of the circular linked list
    private int processCount = 0; // Total number of processes

    // Add a new process at the end of the circular linked list
    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        processCount++;
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processID) {
        if (head == null) {
            System.out.println("No processes to remove!");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;

        // If the process to remove is the head
        if (current.processID == processID) {
            if (head == tail) { // Only one process in the list
                head = tail = null;
            } else {
                tail.next = head.next;
                head = head.next;
            }
            processCount--;
            return;
        }

        // Traverse to find the process
        do {
            prev = current;
            current = current.next;
        } while (current != head && current.processID != processID);

        if (current.processID == processID) {
            prev.next = current.next;
            if (current == tail) {
                tail = prev; // Update tail if the process is at the end
            }
            processCount--;
        } else {
            System.out.println("Process ID " + processID + " not found!");
        }
    }

    // Simulate round-robin scheduling with a fixed time quantum
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to execute!");
            return;
        }

        ProcessNode current = head;
        int totalTime = 0; // Total execution time
        int waitingTime = 0; // Total waiting time
        int turnAroundTime = 0; // Total turn-around time

        System.out.println("Starting Round Robin Scheduling...");
        while (processCount > 0) {
            System.out.println("Executing Process ID: " + current.processID + " | Remaining Burst Time: " + current.burstTime);
            if (current.burstTime <= timeQuantum) {
                // Process completes within this quantum
                totalTime += current.burstTime;
                turnAroundTime += totalTime;
                waitingTime += totalTime - current.burstTime;
                System.out.println("Process ID: " + current.processID + " completed!");
                removeProcess(current.processID);
                if (head == null) break; // No more processes
                current = head; // Start from the head after removal
            } else {
                // Process requires more time
                totalTime += timeQuantum;
                current.burstTime -= timeQuantum;
                current = current.next; // Move to the next process
            }

            // Display the current state of the circular queue
            displayProcesses();
        }

        // Calculate and display average waiting and turn-around times
        System.out.println("Average Waiting Time: " + (waitingTime / (double) (processCount + 1)));
        System.out.println("Average Turn-Around Time: " + (turnAroundTime / (double) (processCount + 1)));
    }

    // Display the list of processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        System.out.println("Processes in the Queue:");
        ProcessNode current = head;
        do {
            System.out.println("Process ID: " + current.processID + " | Burst Time: " + current.burstTime + " | Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    // Main method to test the Round Robin Scheduling
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Adding processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 15, 2);
        scheduler.addProcess(3, 20, 1);
        scheduler.addProcess(4, 25, 3);

        // Display initial list of processes
        scheduler.displayProcesses();

        // Simulate Round Robin Scheduling with a time quantum of 5
        scheduler.simulateRoundRobin(5);
    }
}
