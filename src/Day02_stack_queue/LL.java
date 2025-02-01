package Day02_stack_queue;

class Node{
     String name;
     int enroll;
     int age;
    Node next;


    Node(String name, int enroll, int age){
        this.name=name;
        this.enroll = enroll;
        this.age = age;

    }
}

class Student{
    Node head ;
    Node tail ;

    public void addStduent(String name, int enroll, int age){
        Node newNode = new Node(name,enroll,age);

        if(tail == null && head == null){
            tail =  newNode;
            head = newNode;

        }
        else{
            tail.next = newNode;
            tail = newNode;
        }


    }
    public void display(int age){
        // age = addStduent(name, enroll, age);
        Node temp = head;
        while (temp != null) {
            if (temp.age == age) {
                System.out.println("Student name: " + temp.name );
                System.out.println("Enrollment: " + temp.enroll );
                System.out.println("Age: " + temp.age);
            }else{
                System.out.println("Age is not matching");
            }
            temp = temp.next;
        }
    }
}
public class LL {
    public static void main(String[] args) {
        Student student = new Student();

        student.addStduent("Rahul", 109, 12);


        student.display(12);

    }
}
