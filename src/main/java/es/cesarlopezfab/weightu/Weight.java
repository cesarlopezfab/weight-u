package es.cesarlopezfab.weightu;

import java.util.Date;

public class Weight {

	final Double value;
	final Date created;

	Weight(Double weight, Date created) {
		this.value = weight;
		this.created = created;
	}

	public Date created() {
		return created;
	}

	public Double value() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Weight)) {
			Weight other = (Weight) obj;
			return this.value.equals(other.value) && this.created.equals(other.created);
		}

		return false;
	}

}