package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bean.Address;
import com.bean.Student;

@Configuration // spring.xml
@ComponentScan(basePackages = "com")
public class AppConfig {

	@Bean
	public Address address() {
		Address address = new Address();
		address.setCity("PUNE");
		address.setState("MH");
		address.setPincode(421124);
		return address;
	}

	@Bean
	public Student stud() {
		Student student = new Student(11, "Kareena", 66.66, address());
		return student;
	}

}
