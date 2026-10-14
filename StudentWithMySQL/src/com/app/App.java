package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Student;
import com.config.AppConfig;
import com.service.StudentService;

public class App {

	public static void main(String[] args) {

		Student s1 = new Student(1, "Deepika Padukone", 85.5);
		Student s2 = new Student(2, "Alia Bhatt", 90.0);
		Student s3 = new Student(3, "Katrina Kaif", 88.5);
		Student s4 = new Student(4, "Priyanka Chopra", 92.0);
		Student s5 = new Student(5, "Kareena Kapoor", 87.5);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// StudentService service
		// =(StudentService)context.getBean(StudentServiceImpl.class);
		StudentService service = (StudentService) context.getBean(StudentService.class);
		//StudentService service = (StudentService) context.getBean("studentServiceImpl");
//		StudentService service1 = (StudentService) context.getBean(StudentService.class);

		service.enrolledStudent(s1);
		service.enrolledStudent(s2);
		service.enrolledStudent(s3);
		service.enrolledStudent(s4);
		service.enrolledStudent(s5);

		System.out.println("----------------------------");

	}

}
