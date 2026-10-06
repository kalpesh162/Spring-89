package com.app;

import com.bean.Car;
import com.bean.Engine;
import com.util.EngineFactory;

public class App {

	public static void main(String[] args) {

		Engine engine = EngineFactory.getEngine("disel");

		Car car = new Car(engine);

		car.getEngine().on();

	}

}
