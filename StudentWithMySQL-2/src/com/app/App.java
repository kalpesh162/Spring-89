package com.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Student;
import com.config.AppConfig;
import com.service.StudentService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		StudentService service = context.getBean(StudentService.class);

		// 1. INSERT STUDENTS
		System.out.println("========== INSERT STUDENTS ==========");

		Student s1 = new Student("Rahul Sharma", 78.5);
		Student s2 = new Student("Anjali Verma", 89.0);
		Student s3 = new Student("Amit Patil", 82.5);
		Student s4 = new Student("Sneha Joshi", 94.0);
		Student s5 = new Student("Rohan Mehta", 86.5);

		service.enrolledStudent(s1);
		service.enrolledStudent(s2);
		service.enrolledStudent(s3);
		service.enrolledStudent(s4);
		service.enrolledStudent(s5);

		System.out.println("Students inserted successfully!");

		// 2. DISPLAY ALL STUDENTS
		System.out.println("\n========== ALL STUDENTS ==========");

		List<Student> students = service.getAllStudents();

		for (Student s : students) {
			System.out.println(s);
		}

		// 3. FIND STUDENT BY ID
		// Replace 1 with an ID that exists in your database.
		System.out.println("\n========== FIND STUDENT BY ID ==========");

		int searchId = 1;
		Student student = service.getStudentById(searchId);

		if (student != null) {
			System.out.println("Student found: " + student);
		} else {
			System.out.println("Student not found with ID: " + searchId);
		}

		// 4. UPDATE STUDENT
		System.out.println("\n========== UPDATE STUDENT ==========");

		Student updatedStudent = new Student("Anjali Verma", 96.5);

		boolean updated = service.modifyStudent(searchId, updatedStudent);

		if (updated) {
			System.out.println("Student updated successfully!");
		} else {
			System.out.println("Student update failed!");
		}

		// VERIFY UPDATE
		System.out.println("\n========== AFTER UPDATE ==========");

		System.out.println(service.getStudentById(searchId));

		// 5. DELETE STUDENT
		System.out.println("\n========== DELETE STUDENT ==========");

		int deleteId = 2;
		service.removeStudentById(deleteId);

		System.out.println("Delete operation executed for ID: " + deleteId);

		// 6. DISPLAY ALL STUDENTS AFTER DELETE
		System.out.println("\n========== AFTER DELETE ==========");

		List<Student> remainingStudents = service.getAllStudents();

		for (Student s : remainingStudents) {
			System.out.println(s);
		}

		context.close();
	}
}
