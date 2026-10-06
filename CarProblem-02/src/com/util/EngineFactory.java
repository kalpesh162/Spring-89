package com.util;

import com.bean.Engine;
import com.bean.PetrolEngine;

public class EngineFactory {

	public static Engine getEngine(String type) {
		type = type.toLowerCase();
		switch (type) {
		case "petrol":
			return new PetrolEngine();
		case "disel":
			return new PetrolEngine();
		case "electric":
			return new PetrolEngine();

		default:
			throw new IllegalArgumentException("Argume t not valid " + type);
		}

	}

}
