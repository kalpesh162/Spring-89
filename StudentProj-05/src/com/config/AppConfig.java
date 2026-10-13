package com.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bean.Address;
import com.bean.Student;

@Configuration // spring.xml
@ComponentScan(basePackages = "com")
public class AppConfig {

	@Bean
	@Primary
	public Address address() {
		Address address = new Address();
		address.setCity("PUNE");
		address.setState("MH");
		address.setPincode(421124);
		return address;
	}

	@Bean
	public Address address1() {
		Address address = new Address();
		address.setCity("MUMBAI");
		address.setState("MH");
		address.setPincode(124421);
		return address;
	}

	@Bean
	public Student stud(@Qualifier("address1") Address add) {
		// Student student = new Student(11, "Kareena", 66.66, address());
		Student student = new Student(11, "Kareena", 66.66, add);
		return student;
	}

	@Bean
	public Student student(Address add) {
		// Student student = new Student(11, "Kareena", 66.66, address());
		Student student = new Student(11, "Kareena", 66.66, add);
		return student;
	}

}
