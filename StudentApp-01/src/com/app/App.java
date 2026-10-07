package com.app;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bean.Employee;

public class App {

	public static void main(String[] args) {

		// Employee employee=new Employee(11,"Kalpesh", 10000);

		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring.xml");

		Resource resource = new ClassPathResource("spring.xml");
		BeanFactory factory = new XmlBeanFactory(resource);

		System.out.println("HELLO.....");
		
		//Employee employee=(Employee)factory.getBean("employee");
		//System.out.println(employee);
		/*
		Employee employee=(Employee)factory.getBean(Employee.class);
		System.out.println(employee);
		*/
		
  // Bean Factory is lazy
		// ApplicationConteext  Egarly | Early
	}

}
