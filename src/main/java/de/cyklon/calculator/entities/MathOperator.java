package de.cyklon.calculator.entities;

import java.util.List;
import java.util.function.BiFunction;

public interface MathOperator extends MathEntity {

	static List<MathOperator> operators = List.of(plus(), minus(), times(), divide());

	static MathOperator plus() {
		return new Impl(Double::sum, false, '+');
	}

	static MathOperator minus() {
		return new Impl((x, y) -> x-y, false, '-');
	}

	static MathOperator times() {
		return new Impl((x, y) -> x*y, true, '*');
	}

	static MathOperator divide() {
		return new Impl((x, y) -> x/y, true, '/');
	}

	static MathOperator valueOf(char symbol) {
		for (MathOperator operator : operators) if (operator.symbol()==symbol) return operator;
		throw new IllegalArgumentException("operator " + symbol + " not found!");
	}

	double calculate(double x, double y);

	default double calculate(MathNum x, MathNum y) {
		return calculate(x.value(), y.value());
	}

	boolean priority();

	char symbol();

	static class Impl implements MathOperator {

		private final BiFunction<Double, Double, Double> operator;
		private final boolean priority;
		private final char symbol;

		public Impl(BiFunction<Double, Double, Double> operator, boolean priority, char symbol) {
			this.operator = operator;
			this.priority = priority;
			this.symbol = symbol;
		}

		@Override
		public double calculate(double x, double y) {
			return operator.apply(x, y);
		}

		@Override
		public boolean priority() {
			return priority;
		}

		@Override
		public char symbol() {
			return symbol;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof MathOperator op && op.symbol()==symbol;
		}

		@Override
		public int hashCode() {
			return symbol;
		}

		@Override
		public String toString() {
			return String.valueOf(symbol);
		}
	}

}
