package es.cesarlopezfab.weightu;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WeightBuilderTest {

	@Test
	public void buildFromMap() {
		Weight weight = Mother.defaultOne();
		Map<String, String> map = new HashMap<>();
		map.put("value", weight.value.toString());

		WeightBuilder builder = new WeightBuilder(Mother.FACTORY);
		Weight expectedWeight = builder.from(map);
		assertEquals(weight, expectedWeight);
	}

}
