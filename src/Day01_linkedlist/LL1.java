package Day01_linkedlist;

public class LL1 {
    private Node head;
    private Node tail;
    private int size;

    LL1(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
             tail = head;
        }
        size+=1;
    }
    public void insertLast(int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size+=1;

    }
    public void insert( int val, int index){
        Node newNode = new Node(val);
        Node temp = head;

        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }
        for(int i=0; i<index-1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        size+=1;
    }
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }
        int val = head.value; // Store the value of the node being deleted (optional)
        head = head.next; // Move the head pointer to the next node
        if (head == null) { // If the list becomes empty, update the tail to null
            tail = null;
        }
        size -= 1; // Decrease the size of the list
        System.out.println("Deleted value: " + val); // Optionally print the deleted value
    }



public void deleteLast() {
    if (head == null) { // Check if the list is empty
        System.out.println("List is empty, nothing to delete.");
        return;
    }

    if (head == tail) { // If there's only one element in the list
        System.out.println("Deleted value: " + head.value);
        head = null; // Set head to null
        tail = null; // Set tail to null
        size = 0; // Reset size
        return;
    }

    // Traverse to the second-to-last node
    Node current = head;
    while (current.next != tail) {
        current = current.next;
    }

    System.out.println("Deleted value: " + tail.value); // Optionally print the deleted value
    tail = current; // Update the tail to the second-to-last node
    tail.next = null; // Remove the reference to the last node
    size -= 1; // Decrement the size
}
public Node reverse(){

        Node temp = head;
        Node prev = null;

        while(temp != null){
            Node curNext = temp.next;

            temp.next = prev;
            prev = temp;
            temp = curNext;
        }
        return prev;

}


public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+ "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void displayRev(Node ans){
        Node temp = ans;
        while(temp!=null){
            System.out.print(temp.value+ "->");
            temp = temp.next;
        }
        System.out.println("END");
    }
    private class Node{
        private int value;
        private Node next;
        Node(int value){
            this.value=value;
        }
    }


    public static void main(String[] args) {
        LL1 node = new LL1();
        node.insertFirst(30);
        node.insertFirst(1);
        node.insertFirst(23);

        node.display();

        node.insertLast(34);;
        node.insertLast(12);
        node.display();

        node.insert(2, 1);
        node.display();

        node.insert(10, 6);
        node.display();

        node.insert(3,0);
        node.display();

        node.deleteFirst();
        node.display();
        node.deleteLast();
        node.display();
        Node ans = node.reverse();
        node.displayRev(ans);

    }

}
