import java.util.*;

class Student {
    String name;
    int roll;
    String grade;

    Student(String name, int roll, String grade) {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Roll No: " + roll + ", Name: " + name + ", Grade: " + grade);
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Name or Grade cannot be empty.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("Student added successfully.");
    }

    void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                s.display();
            }
        }
    }

    void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt(); sc.nextLine();
        for (Student s : students) {
            if (s.roll == roll) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void removeStudent() {
        System.out.print("Enter Roll No to remove: ");
        int roll = sc.nextInt(); sc.nextLine();
        boolean removed = students.removeIf(s -> s.roll == roll);
        if (removed) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    void start() {
        int choice;
        do {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> removeStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.start();
    }
}
