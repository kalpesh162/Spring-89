package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Student;
import com.config.AppConfig;

public class App {

	public static void main(String[] args) {

//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

		Student student = (Student) context.getBean("student");

		System.out.println(student);
		
		System.out.println("Hello");

	}

}
