package es.cesarlopezfab.weightu;

class WeightFactory {

	final TimeProvider timeProvider;

	WeightFactory() {
		this(new TimeProvider() {
		});
	}

	WeightFactory(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

	public Weight build(Double weight) {
		return new Weight(weight, timeProvider.now());
	}

}
