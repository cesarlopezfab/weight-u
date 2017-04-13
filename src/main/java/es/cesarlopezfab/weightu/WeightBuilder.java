package es.cesarlopezfab.weightu;

import java.util.Map;

public class WeightBuilder {

	final WeightFactory factory;
	
	public WeightBuilder() {
		this(new WeightFactory());
	}

	WeightBuilder(WeightFactory factory) {
		this.factory = factory;
	}

	public Weight from(Map<String, String> map) {
		return factory.build(Double.valueOf(map.get("value")));
	}
}