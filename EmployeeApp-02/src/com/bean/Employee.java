package com.bean;

public class Employee {
	private int id;
	private String name;
	private double salary;
	// has-a
	private Address address;

	public Employee() {
		System.out.println("Deault Constructor");
	}

	public Employee(int id, String name, double salary) {
		System.out.println("Parameterized Constructor  3 Args");
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee(int id, String name, double salary, Address address) {
		System.out.println("Parameterized Constructor  4 Args");
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("SET ID");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("SET NAME");
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		System.out.println("SET SALARY");
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("SET ADDRESS");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
