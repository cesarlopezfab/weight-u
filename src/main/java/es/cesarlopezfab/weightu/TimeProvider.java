package es.cesarlopezfab.weightu;

import java.util.Date;

interface TimeProvider {
	default Date now() {
		return new Date();
	}
}