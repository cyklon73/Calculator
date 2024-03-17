package de.cyklon.calculator;

import de.cyklon.calculator.entities.MathNum;
import de.cyklon.calculator.entities.MathObject;
import de.cyklon.calculator.entities.MathOperator;

public class Calculator {

	public static void main(String[] args) {
		MathObject obj = Parser.parse("10.2*2.5-4.8/2.4+3.6");
		System.out.println(obj);
		System.out.println(obj.calculate());
		/*MathObject obj = new MathObject(
				MathNum.valueOf(10), MathOperator.times(), MathNum.valueOf(3), MathOperator.plus(), MathNum.valueOf(5), MathOperator.minus(),
				MathNum.valueOf(6), MathOperator.divide(), MathNum.valueOf(2), MathOperator.plus(), MathNum.valueOf(8), MathOperator.times(),
				MathNum.valueOf(4), MathOperator.minus(), MathNum.valueOf(3), MathOperator.divide(), MathNum.valueOf(2), MathOperator.plus(),
				MathNum.valueOf(10), MathOperator.minus(), MathNum.valueOf(4), MathOperator.times(), MathNum.valueOf(2), MathOperator.divide(),
				MathNum.valueOf(3), MathOperator.plus(), MathNum.valueOf(7), MathOperator.minus(), MathNum.valueOf(2), MathOperator.times(),
				MathNum.valueOf(3), MathOperator.divide(), MathNum.valueOf(2), MathOperator.plus(), MathNum.valueOf(5)
		);
		obj.calculate();*/
	}

}
