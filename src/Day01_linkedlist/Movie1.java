package Day01_linkedlist;

// Node class representing a movie
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    // Constructor
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List class for Movie Management System
class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Constructor
    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at the beginning: " + title);
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at the end: " + title);
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position exceeds the length of the list. Movie added at the end.");
            addMovieAtEnd(title, director, year, rating);
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
            System.out.println("Movie added at position " + position + ": " + title);
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty. No movie to remove.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Movies directed by " + director + ":");
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println(current.title + " (" + current.year + ") - Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        System.out.println("Movies with rating " + rating + ":");
        while (current != null) {
            if (current.rating == rating) {
                System.out.println(current.title + " (" + current.year + ") - Directed by: " + current.director);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        MovieNode current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in forward order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Directed by: " + current.director + " - Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        MovieNode current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in reverse order:");
        while (current != null) {
            System.out.println(current.title + " (" + current.year + ") - Directed by: " + current.director + " - Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRatingByTitle(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title + " - New Rating: " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }
}

// Main class to test the Movie Management System
public class Movie1 {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        // Adding movies
        system.addMovieAtBeginning("Baahubali", "S.S. Rajamouli", 2015, 8.0);
        system.addMovieAtEnd("Dangal", "Nitesh Tiwari", 2016, 8.4);
        system.addMovieAtPosition("3 Idiots", "Rajkumar Hirani", 2009, 8.4, 2);

        // Display movies
        system.displayForward();
        system.displayReverse();

        // Search movies
        system.searchByDirector("Rajkumar Hirani");
        system.searchByRating(8.4);

        // Update rating
        system.updateRatingByTitle("Baahubali", 8.5);

        // Remove movie
        system.removeMovieByTitle("Dangal");

        // Display movies after removal
        system.displayForward();
    }
}