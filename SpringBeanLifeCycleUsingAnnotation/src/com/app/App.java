package com.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Tree;

public class App {

	public static void main(String[] args) {

		// ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		// ClassPathXmlApplicationContext context=new
		// ClassPathXmlApplicationContext("spring.xml");

		Tree tree = (Tree) context.getBean("tree");

		System.out.println(tree);

		context.registerShutdownHook();

	}

}
