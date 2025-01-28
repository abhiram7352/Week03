package Day01_linkedlist;

// Node class to represent each item in the inventory
class Node {
    String itemName; // Name of the item
    int itemID; // Unique ID of the item
    int quantity; // Quantity of the item
    double price; // Price of the item
    Node next; // Pointer to the next node

    // Constructor for initializing the node
    Node(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Singly Linked List implementation for Inventory Management
public class InventoryManagementSystem {
    private Node head; // Head of the linked list

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Node newNode = new Node(itemName, itemID, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add an item at a specific position (1-based index)
    public void addAtPosition(String itemName, int itemID, int quantity, double price, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(itemName, itemID, quantity, price);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove an item by Item ID
    public void removeByID(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        // If the head node is the one to be removed
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item ID not found!");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Update the quantity of an item by Item ID
    public void updateQuantityByID(int itemID, int newQuantity) {
        Node temp = head;
        while (temp != null && temp.itemID != itemID) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item ID not found!");
        } else {
            temp.quantity = newQuantity;
        }
    }

    // Search for an item by Item ID or Item Name
    public void search(String searchKey) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (String.valueOf(temp.itemID).equals(searchKey) || temp.itemName.equalsIgnoreCase(searchKey)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemID + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found!");
        }
    }

    // Calculate and display the total value of the inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Node temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Sort the inventory by Item Name in ascending order
    public void sortByName() {
        if (head == null || head.next == null) {
            return;
        }

        Node current, index;
        for (current = head; current != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.itemName.compareToIgnoreCase(index.itemName) > 0) {
                    swapNodes(current, index);
                }
            }
        }
    }

    // Sort the inventory by Price in ascending order
    public void sortByPrice() {
        if (head == null || head.next == null) {
            return;
        }

        Node current, index;
        for (current = head; current != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.price > index.price) {
                    swapNodes(current, index);
                }
            }
        }
    }

    // Helper method to swap two nodes
    private void swapNodes(Node a, Node b) {
        String tempName = a.itemName;
        int tempID = a.itemID;
        int tempQuantity = a.quantity;
        double tempPrice = a.price;

        a.itemName = b.itemName;
        a.itemID = b.itemID;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemName = tempName;
        b.itemID = tempID;
        b.quantity = tempQuantity;
        b.price = tempPrice;
    }

    // Display all items in the inventory
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }

        Node temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + " (ID: " + temp.itemID + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
            temp = temp.next;
        }
    }

    // Main method to test the Inventory Management System
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();

        // Adding items
        inventory.addAtEnd("Laptop", 101, 5, 50000);
        inventory.addAtEnd("Phone", 102, 10, 20000);
        inventory.addAtBeginning("Tablet", 103, 7, 15000);

        // Display inventory
        inventory.displayInventory();

        // Search for an item
        inventory.search("102");
        inventory.search("Laptop");

        // Update quantity
        inventory.updateQuantityByID(101, 8);
        inventory.displayInventory();

        // Remove an item
        inventory.removeByID(103);
        inventory.displayInventory();

        // Calculate total inventory value
        inventory.calculateTotalValue();

        // Sort by name
        inventory.sortByName();
        inventory.displayInventory();

        // Sort by price
        inventory.sortByPrice();
        inventory.displayInventory();
    }
}
