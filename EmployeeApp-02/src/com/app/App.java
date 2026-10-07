package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Address;
import com.bean.Employee;

public class App {

	public static void main(String[] args) {

		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		
		
		
		System.out.println("+++++++++++++++++++++++++++++++++");
		Address address=(Address)context.getBean("address1");
		System.out.println(address);
		
		Employee employee=(Employee)context.getBean("employee1");
		
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		System.out.println(employee.getAddress());
		
		System.out.println("-----------------------------------------------------------------");
		System.out.println(context.getBean("employee2"));
		
		
		
	}

}
