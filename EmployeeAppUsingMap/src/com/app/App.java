package com.app;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		Employee employee = (Employee) context.getBean("employee1");

		System.out.println(employee);
		System.out.println(employee.getDepts());
		
		Map<Integer, String> empMap=employee.getDepts();
		
		Set<Map.Entry<Integer, String>> entries=empMap.entrySet();
		 for(Map.Entry<Integer,String> entry:entries) {
			 System.out.println(entry.getKey() +"  "+ entry.getValue());
		 }
		
		 System.out.println("-------------------------------");
	//	Set<Integer> keys=empMap.keySet();
		
		for(Integer key : empMap.keySet())
			System.out.println(key);
		
		System.out.println("-------------------------------");
		Collection<String> value=empMap.values();
	
	}

}
