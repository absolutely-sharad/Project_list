import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.HashMap;
class Student {
    public String name;
    public int rollNo;
    public int age;
    public int marks;

    public Student(String name, int rollNo, int age, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.marks = marks;
    }

    public void viewStudent() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Student> database = new HashMap<Integer, Student>();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Students");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Student's Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter roll number:");
                    int rollNo = sc.nextInt();
                    System.out.println("Enter age:");
                    int age = sc.nextInt();
                    System.out.println("Enter marks:");
                    int marks = sc.nextInt();
                    Student std = new Student(name, rollNo, age, marks);
                    database.put(rollNo, std);
                    System.out.println("Student added successfuly");
                    break;
                case 2:
                    System.out.println("List of students: ");
                    for (Student i : database.values()) {
                        i.viewStudent();
                    }
                    break;
                case 3:
                    System.out.println("Enter Roll No.:");
                    int rollno = sc.nextInt();
                    Student data = database.get(rollno);
                    if (data != null) {
                        data.viewStudent();
                    } else {
                        System.out.println("Student not found");
                    }
                    System.out.println("--------------------------");
                    break;
                case 4:
                    int totalStudent = database.size();
                    int totalMarks = 0;
                    for (Student j : database.values()) {
                        totalMarks = totalMarks + j.marks;
                    }
                    double average = (double) totalMarks / totalStudent;
                    System.out.println("Average Marks: " + average);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                }
            }
        }
    }
