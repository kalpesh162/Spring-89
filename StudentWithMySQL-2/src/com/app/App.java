package com.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Student;
import com.config.AppConfig;
import com.service.StudentService;

public class App {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// StudentService service
		// =(StudentService)context.getBean(StudentServiceImpl.class);
		StudentService service = (StudentService) context.getBean(StudentService.class);
		// StudentService service = (StudentService)
		// context.getBean("studentServiceImpl");
//		StudentService service1 = (StudentService) context.getBean(StudentService.class);
		/*
		 * Student s1 = new Student(1, "Deepika Padukone", 85.5); Student s2 = new
		 * Student(2, "Alia Bhatt", 90.0); Student s3 = new Student(3, "Katrina Kaif",
		 * 88.5); Student s4 = new Student(4, "Priyanka Chopra", 92.0); Student s5 = new
		 * Student(5, "Kareena Kapoor", 87.5);
		 * 
		 * AnnotationConfigApplicationContext context = new
		 * AnnotationConfigApplicationContext(AppConfig.class); // StudentService
		 * service // =(StudentService)context.getBean(StudentServiceImpl.class);
		 * StudentService service = (StudentService)
		 * context.getBean(StudentService.class); //StudentService service =
		 * (StudentService) context.getBean("studentServiceImpl"); // StudentService
		 * service1 = (StudentService) context.getBean(StudentService.class);
		 * 
		 * service.enrolledStudent(s1); service.enrolledStudent(s2);
		 * service.enrolledStudent(s3); service.enrolledStudent(s4);
		 * service.enrolledStudent(s5);
		 * 
		 * System.out.println("----------------------------");
		 */
		// 1. Display all students
		System.out.println("----- ALL STUDENTS -----");
		List<Student> students = service.getAllStudents();

		for (Student s : students) {
			System.out.println(s);
		}

		// 2. Find student by ID
		System.out.println("----- FIND STUDENT BY ID -----");
		Student student = service.getStudentById(1);

		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student not found");
		}

		// 3. Update student
		System.out.println("----- UPDATE STUDENT -----");
		Student updatedStudent = new Student(1, "Deepika Padukone", 95.0);

		boolean updated = service.modifyStudent(1, updatedStudent);

		if (updated) {
			System.out.println("Student updated successfully");
		} else {
			System.out.println("Student not found or update failed");
		}

		// Verify update
		System.out.println("----- AFTER UPDATE -----");
		System.out.println(service.getStudentById(1));

		// 4. Delete student
		System.out.println("----- DELETE STUDENT -----");
		//service.removeStudentById(4);

		System.out.println("Student deleted successfully");

		// Verify deletion
		System.out.println("----- AFTER DELETE -----");
		for (Student student2 : service.getAllStudents())
			System.out.println(student2);

		context.close();

	}

}
