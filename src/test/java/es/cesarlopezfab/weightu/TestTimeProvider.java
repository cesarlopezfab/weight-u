package es.cesarlopezfab.weightu;

import java.util.Date;

class TestTimeProvider implements TimeProvider {

	final Date now = new Date();

	@Override
	public Date now() {
		return now;
	}

}