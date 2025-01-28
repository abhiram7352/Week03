package Day01_linkedlist;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head; // Points to the first ticket in the circular linked list
    private Ticket tail; // Points to the last ticket in the circular linked list
    private int totalTickets;

    public TicketReservationSystem() {
        this.head = null;
        this.tail = null;
        this.totalTickets = 0;
    }

    // Add a new ticket reservation
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            // First ticket in the list
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circular link
        } else {
            tail.next = newTicket; // Add new ticket to the end
            newTicket.next = head; // Point the last ticket to the first
            tail = newTicket; // Update tail
        }

        totalTickets++;
        System.out.println("Ticket added: " + ticketID + " for " + customerName);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail; // Start with the tail as the previous node (circular list)

        do {
            if (current.ticketID == ticketID) {
                if (current == head && current == tail) {
                    // Only one ticket in the list
                    head = null;
                    tail = null;
                } else {
                    previous.next = current.next; // Skip the current ticket
                    if (current == head) {
                        head = current.next; // Update head if it's the first ticket
                    }
                    if (current == tail) {
                        tail = previous; // Update tail if it's the last ticket
                    }
                }

                totalTickets--;
                System.out.println("Ticket removed: " + ticketID);
                return;
            }

            previous = current;
            current = current.next;
        } while (current != head); // Loop through the circular list

        System.out.println("Ticket ID " + ticketID + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Current ticket reservations:");
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head); // Loop through the circular list
    }

    // Search for tickets by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket current = head;

        System.out.println("Search results for: " + query);
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head); // Loop through the circular list

        if (!found) {
            System.out.println("No tickets found for: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public int getTotalTickets() {
        return totalTickets;
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        // Adding tickets
        system.addTicket(1, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(2, "Bob", "Interstellar", "B2", "12:00 PM");
        system.addTicket(3, "Charlie", "Inception", "A3", "10:00 AM");

        // Display tickets
        system.displayTickets();

        // Search tickets
        system.searchTicket("Inception");
        system.searchTicket("Alice");

        // Remove a ticket
        system.removeTicket(2);

        // Display tickets after removal
        system.displayTickets();

        // Total tickets
        System.out.println("Total tickets booked: " + system.getTotalTickets());
    }
}
