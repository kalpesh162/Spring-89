package com.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Tree implements InitializingBean, DisposableBean {
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

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init method");
	}

}
