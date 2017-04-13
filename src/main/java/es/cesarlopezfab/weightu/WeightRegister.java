package es.cesarlopezfab.weightu;

import java.util.Stack;

class WeightRegister {

		private final Stack<Weight> weights = new Stack<>();

		public Weight getLastWeight() {
			return weights.lastElement();
		}

		public void add(Weight weight) {
			weights.add(weight);
		}

	}
