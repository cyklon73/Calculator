package de.cyklon.calculator;

import de.cyklon.calculator.entities.MathEntity;
import de.cyklon.calculator.entities.MathNum;
import de.cyklon.calculator.entities.MathObject;
import de.cyklon.calculator.entities.MathOperator;

import java.util.Arrays;

public class Parser {

	public static MathObject parse(String value) {
		value = value.replaceAll("\\s", "").replace(",", ".");
		StringBuilder regexBuilder = new StringBuilder("[");

		MathOperator.operators.forEach(regexBuilder::append);
		String regex = regexBuilder.append("]").toString().replace("-", "\\-");
		MathNum[] nums = Arrays.stream(value.split(regex))
				.map(Double::parseDouble)
				.map(MathNum::valueOf)
				.toArray(MathNum[]::new);

		String ops = value.replaceAll("\\d", "").replace(".", "");
		MathOperator[] operators = new MathOperator[ops.length()];
		for (int i = 0; i < ops.length(); i++) operators[i] = MathOperator.valueOf(ops.charAt(i));

		MathEntity[] entities = new MathEntity[nums.length+operators.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			entities[index++] = nums[i];
			if (i< operators.length) entities[index++] = operators[i];
		}

		return new MathObject(entities);
	}

}
