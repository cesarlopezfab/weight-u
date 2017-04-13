package es.cesarlopezfab.weightu;

public class Mother {

	static final WeightFactory FACTORY = new WeightFactory(new TestTimeProvider());
	private static final Double DEFAULT_WEIGHT = 106.3;

	public static Weight defaultOne() {
		return FACTORY.build(DEFAULT_WEIGHT);
	}

}
