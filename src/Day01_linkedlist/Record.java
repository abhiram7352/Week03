package Day01_linkedlist;

// Class to represent a student node in the linked list
class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next; // Reference to the next node

    // Constructor to create a new student node
    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Class to manage the linked list of student records
class StudentRecord {
    StudentNode head; // Reference to the head of the linked list

    // Constructor to create an empty student record
    public StudentRecord() {

        this.head = null;
    }

    // Method to add a student at the beginning of the list
    public void addStudentBeginning(int rollNo, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Method to add a student at the end of the list
    public void addStudentEnd(int rollNo, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        StudentNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newStudent;
    }

    // Method to add a student at a specific position in the list
    public void addStudentPosition(int rollNo, String name, int age, String grade, int position) {
        StudentNode newStudent = new StudentNode(rollNo, name, age, grade);
        if (position == 0) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        StudentNode current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
            current = current.next;
        }
        newStudent.next = current.next;
        current.next = newStudent;
    }

    // Method to delete a student by their roll number
    public void deleteStudent(int rollNo) {
        StudentNode current = head;
        StudentNode prev = null;
        while (current != null && current.rollNo != rollNo) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student not found");
            return;
        }
        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }
    }

    // Method to search for a student by their roll number
    public StudentNode searchStudent(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Method to display all students in the list
    public void displayStudents() {
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Method to update a student's grade by their roll number
    public void updateGrade(int rollNo, String newGrade) {
        StudentNode student = searchStudent(rollNo);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student not found");
        }
    }
}

// Main class to test the StudentRecord linked list implementation
public class Record {
    public static void main(String[] args) {
        StudentRecord record = new StudentRecord();

        record.addStudentEnd(1, "Aarav Patel", 15, "A"); // Add student at the end

        record.addStudentBeginning(2, "Meera Sharma", 16, "B"); // Add student at the beginning
        record.addStudentPosition(3, "Ishita Gupta", 14, "C", 1); // Add student at position 1 (after head)
        record.displayStudents(); // Display all students
        System.out.println("Updating grade...");
        record.updateGrade(2, "A+"); // Update grade of the student with roll no. 2
        record.displayStudents(); // Display all students again
        System.out.println("Deleting a student...");

        record.deleteStudent(1);
        record.displayStudents();
    }
}
