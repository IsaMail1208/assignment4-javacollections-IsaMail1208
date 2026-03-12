package service;

import java.util.ArrayList;
import java.util.Iterator;
import model.Student;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public void initializeStudents() {
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 1.9));
        students.add(new Student(3, "Charlie", 2.5));
        students.add(new Student(4, "Diana", 3.2));
        students.add(new Student(5, "Ethan", 1.5));
    }

    public void removeLowGPA() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getGpa() < 2.0) {
                iterator.remove();
            }
        }
    }

    public void findHighestGPA() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        Student top = students.get(0);
        for (Student s : students) {
            if (s.getGpa() > top.getGpa()) {
                top = s;
            }
        }

        System.out.println("Student with highest GPA: " + top);
    }

    public void insertAtIndex() {
        Student newStudent = new Student(99, "New Student", 3.0);
        if (students.size() >= 2) {
            students.add(2, newStudent);
        } else {
            students.add(newStudent);
        }
    }

    public void printStudents() {
        System.out.println("--- Students ---");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
