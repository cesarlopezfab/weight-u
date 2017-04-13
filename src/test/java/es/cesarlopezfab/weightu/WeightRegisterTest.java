package es.cesarlopezfab.weightu;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class WeightRegisterTest {

	final Double value = 106.7;
	final TimeProvider provider = new TestTimeProvider();
	final WeightFactory factory = new WeightFactory(provider);

	@Test
	public void ableToAddWeight() {
		final WeightRegister register = new WeightRegister();

		register.add(factory.build(value));

		assertEquals(value, register.getLastWeight().value());
	}

	@Test
	public void addingAWeightWithActualDate() {
		Weight weight = factory.build(value);

		Date date = weight.created();

		assertEquals(provider.now(), date);
	}
	
}
