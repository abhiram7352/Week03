package Day01_linkedlist;

import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userID; // Unique ID for the user
    String name; // Name of the user
    int age; // Age of the user
    List<Integer> friendIDs; // List of friend IDs
    UserNode next; // Pointer to the next user in the list

    UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    private UserNode head; // Head of the singly linked list

    // Add a new user to the list
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Search for a user by User ID
    private UserNode findUserByID(int userID) {
        UserNode current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for a user by Name
    private UserNode findUserByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }
        System.out.println("Friend connection added between User " + userID1 + " and User " + userID2);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        user1.friendIDs.remove((Integer) userID2);
        user2.friendIDs.remove((Integer) userID1);
        System.out.println("Friend connection removed between User " + userID1 + " and User " + userID2);
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUserByID(userID1);
        UserNode user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIDs);
        mutualFriends.retainAll(user2.friendIDs);

        System.out.println("Mutual Friends between User " + userID1 + " and User " + userID2 + ": " + mutualFriends);
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        UserNode user = findUserByID(userID);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("Friends of User " + userID + " (" + user.name + "): " + user.friendIDs);
    }

    // Count the number of friends for each user
    public void countFriends() {
        UserNode current = head;

        while (current != null) {
            System.out.println("User " + current.userID + " (" + current.name + ") has " + current.friendIDs.size() + " friends.");
            current = current.next;
        }
    }

    // Display all users in the system
    public void displayAllUsers() {
        UserNode current = head;

        if (current == null) {
            System.out.println("No users in the system!");
            return;
        }

        System.out.println("All Users:");
        while (current != null) {
            System.out.println("User ID: " + current.userID + " | Name: " + current.name + " | Age: " + current.age + " | Friends: " + current.friendIDs);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Adding users
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 20);
        sm.addUser(4, "Daisy", 28);

        // Adding friend connections
        sm.addFriendConnection(1, 2);
        sm.addFriendConnection(1, 3);
        sm.addFriendConnection(2, 4);

        // Display all users
        sm.displayAllUsers();

        // Display friends of a user
        sm.displayFriends(1);

        // Find mutual friends
        sm.findMutualFriends(1, 2);

        // Remove a friend connection
        sm.removeFriendConnection(1, 3);

        // Count friends for each user
        sm.countFriends();

        // Display all users again to see updates
        sm.displayAllUsers();
    }
}
