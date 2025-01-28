package Day01_linkedlist;

// Node class to represent each book in the library
class BookNode {
    String bookTitle; // Title of the book
    String author; // Author of the book
    String genre; // Genre of the book
    int bookID; // Unique Book ID
    boolean isAvailable; // Availability Status
    BookNode next; // Pointer to the next node
    BookNode prev; // Pointer to the previous node

    // Constructor for initializing a book node
    BookNode(String bookTitle, String author, String genre, int bookID, boolean isAvailable) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List implementation for Library Management
public class LibraryManagementSystem {
    private BookNode head; // Head of the doubly linked list
    private BookNode tail; // Tail of the doubly linked list
    private int bookCount = 0; // Total number of books in the library

    // Add a new book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    // Add a new book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    // Add a new book at a specific position (1-based index)
    public void addAtPosition(String bookTitle, String author, String genre, int bookID, boolean isAvailable, int position) {
        if (position <= 0 || position > bookCount + 1) {
            System.out.println("Invalid position!");
            return;
        }

        BookNode newBook = new BookNode(bookTitle, author, genre, bookID, isAvailable);
        if (position == 1) {
            addAtBeginning(bookTitle, author, genre, bookID, isAvailable);
            return;
        }

        if (position == bookCount + 1) {
            addAtEnd(bookTitle, author, genre, bookID, isAvailable);
            return;
        }

        BookNode current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
        }

        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;

        bookCount++;
    }

    // Remove a book by Book ID
    public void removeByBookID(int bookID) {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        BookNode current = head;

        // If the book to remove is the head
        if (current.bookID == bookID) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // If the list becomes empty
            }
            bookCount--;
            return;
        }

        // Traverse to find the book
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book ID not found!");
            return;
        }

        // Remove the book
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // If the book is at the tail
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        bookCount--;
    }

    // Search for a book by Book Title or Author
    public void search(String searchKey) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(searchKey) || current.author.equalsIgnoreCase(searchKey)) {
                System.out.println("Book Found: " + current.bookTitle + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + ")");
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Update a book's Availability Status by Book ID
    public void updateAvailability(int bookID, boolean newStatus) {
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book ID not found!");
        } else {
            current.isAvailable = newStatus;
        }
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty!");
            return;
        }

        BookNode current = head;
        System.out.println("Books in Library (Forward Order):");
        while (current != null) {
            System.out.println(current.bookTitle + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + ")");
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty!");
            return;
        }

        BookNode current = tail;
        System.out.println("Books in Library (Reverse Order):");
        while (current != null) {
            System.out.println(current.bookTitle + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookID + ", Available: " + current.isAvailable + ")");
            current = current.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        return bookCount;
    }

    // Main method to test the Library Management System
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books
        library.addAtEnd("Book A", "Author X", "Fiction", 101, true);
        library.addAtEnd("Book B", "Author Y", "Non-Fiction", 102, false);
        library.addAtBeginning("Book C", "Author Z", "Mystery", 103, true);

        // Display books
        library.displayForward();
        library.displayReverse();

        // Search for a book
        library.search("Book B");
        library.search("Author Z");

        // Update availability
        library.updateAvailability(102, true);

        // Remove a book
        library.removeByBookID(101);
        library.displayForward();

        // Count total books
        System.out.println("Total Books in Library: " + library.countBooks());
    }
}
