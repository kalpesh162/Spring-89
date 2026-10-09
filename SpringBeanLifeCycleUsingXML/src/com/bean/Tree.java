package com.bean;

public class Tree {
	private String name;
	private double ht;
	
	{
		 System.out.println("Instance Block");
	}
	public Tree() {
		System.out.println("Default Constructor");
	}
	
	
	public Tree(String name, double ht) {
		System.out.println("Parameterized Constructor");
		this.name = name;
		this.ht = ht;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("SET NAME");
		this.name = name;
	}
	public double getHt() {
		return ht;
	}
	public void setHt(double ht) {
		System.out.println("SET HEIGHT");
		this.ht = ht;
	}
	@Override
	public String toString() {
		return "Tree [name=" + name + ", ht=" + ht + "]";
	}
	
	// Extra Intialization
	public void initmethod() {
		System.out.println("init method");
		System.out.println("Serving Water");
	}
	
	// Cleap Up
		public void destroy() {
				System.out.println("Ceremoney Tree");
		}
	
	

}
