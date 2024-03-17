package de.cyklon.calculator.entities;

public interface MathNum extends MathEntity {

	static MathNum valueOf(double value) {
		return new Impl(value);
	}

	double value();

	static class Impl extends Number implements MathNum {

		private final double value;

		public Impl(double value) {
			this.value = value;
		}

		@Override
		public double value() {
			return value;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Number n && n.doubleValue()==value;
		}

		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		@Override
		public int intValue() {
			return (int) value;
		}

		@Override
		public long longValue() {
			return (long) value;
		}

		@Override
		public float floatValue() {
			return (float) value;
		}

		@Override
		public double doubleValue() {
			return value;
		}
	}

}
