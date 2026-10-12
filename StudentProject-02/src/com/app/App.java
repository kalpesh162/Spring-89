package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Student;
import com.config.AppConfig;

public class App {

	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = (Student) context.getBean("stud");

		System.out.println(student);

		System.out.println(student.getAddress());

		System.out.println("Hello");

	}

}
