package com.java;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeManagementSystem {
	private ArrayList<Student> students;
	private Scanner scanner;

	public StudentGradeManagementSystem() {
		students = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void addStudent() {
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();
		System.out.print("Enter roll number: ");
		int rollNumber = scanner.nextInt();
		scanner.nextLine(); 
		Student student = new Student(name, rollNumber);
		System.out.print("Enter number of subjects: ");
		int numSubjects = scanner.nextInt();
		scanner.nextLine(); 
		for (int i = 0; i < numSubjects; i++) {
			System.out.print("Enter subject name: ");
			String subject = scanner.nextLine();
			System.out.print("Enter marks for " + subject + ": ");
			int marks = scanner.nextInt();
			scanner.nextLine(); 
			student.setSubjectMarks(subject, marks);
		}
		students.add(student);
		System.out.println("Student added successfully.");
	}

	public void updateStudent() {
		System.out.print("Enter roll number of student to update: ");
		int rollNumber = scanner.nextInt();
		scanner.nextLine();
		boolean found = false;
		for (Student student : students) {
			if (student.getRollNumber() == rollNumber) {
				System.out.print("Enter new name for student: ");
				String newName = scanner.nextLine();
				student.name = newName;
				System.out.println("Student updated successfully.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Student not found.");
		}
	}

	public void deleteStudent() {
		System.out.print("Enter roll number of student to delete: ");
		int rollNumber = scanner.nextInt();
		scanner.nextLine();
		boolean removed = false;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getRollNumber() == rollNumber) {
				students.remove(i);
				removed = true;
				System.out.println("Student deleted successfully.");
				break;
			}
		}
		if (!removed) {
			System.out.println("Student not found.");
		}
	}

	public void printStudentInfo(Student student) {
		System.out.println("Name: " + student.getName());
		System.out.println("Roll Number: " + student.getRollNumber());
		Map<String, Integer> subjectMarks = student.getSubjectMarks();
		for (Map.Entry<String, Integer> entry : subjectMarks.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println("Percentage: " + student.calculatePercentage());
		System.out.println("Grade: " + student.calculateGrade());
	}

	public void displayAllStudents() {
		if (students.isEmpty()) {
			System.out.println("No students added yet.");
			return;
		}
		for (Student student : students) {
			printStudentInfo(student);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		StudentGradeManagementSystem system = new StudentGradeManagementSystem();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nStudent Grade Management System");
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Display All Students");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				system.addStudent();
				break;
			case 2:
				system.updateStudent();
				break;
			case 3:
				system.deleteStudent();
				break;
			case 4:
				system.displayAllStudents();
				break;
			case 5:
				System.out.println("Exiting program...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice! Please enter a number from 1 to 5.");
			}
		}
	}
}