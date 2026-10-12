package com.bean;


public class Student {
	private int id;
	private String name;
	private double marks;
	
	private Address address;

	public Student() {
		
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

	
	public void setAddress(Address address) {
		System.out.println("SET Address Called");
		this.address = address;
	}

}
