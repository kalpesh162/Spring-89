package com.app;

import com.bean.Car;
import com.bean.DiselEngine;
import com.bean.Engine;
import com.bean.PetrolEngine;

public class App {
	
	public static void main(String[] args) {
		
		Engine engine=new DiselEngine();
		
		Car car=new Car(engine);
		
		car.setEngine(new PetrolEngine());
		// By using inteface we achieve loosely couple code
		
		
		
	}

}
