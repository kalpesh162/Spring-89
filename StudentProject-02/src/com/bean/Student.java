package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("stud")
public class Student {
	@Value("11")
	private int id;
	@Value("Ravi")
	private String name;
	@Value("55.55")
	private double marks;

	// ref type
	// 1: @Autowired // Field Injection
	private Address address;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, double marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	//@Autowired   NOT WORKS
	public Student(int id, String name, double marks, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.address = address;
	}

	
	@Autowired   // Constructor Injection
	public Student(Address address) {
		super();
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

	public Address getAddress() {
		return address;
	}

	// 2: @Autowired // setter Injection
	public void setAddress(Address address) {
		System.out.println("SET Address Called");
		this.address = address;
	}

}
