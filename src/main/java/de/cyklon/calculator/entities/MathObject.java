package de.cyklon.calculator.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MathObject implements MathEntity {

	private final MathEntity[] entities;

	public MathObject(MathEntity... entities) {
		this.entities = entities;
	}

	private int indexOf(List<MathEntity> entities, boolean priority) {
		for (int i = 0; i < entities.size(); i++) if (entities.get(i) instanceof MathOperator operator && (!priority || operator.priority())) return i;
		return -1;
	}

	private void calculate(List<MathEntity> entities, int i) {
		double val = ((MathOperator)entities.get(i)).calculate((MathNum) entities.get(i-1), (MathNum) entities.get(i+1));
		entities.remove(i+1);
		entities.remove(i);
		entities.set(i-1, MathNum.valueOf(val));
	}

	public double calculate() {
		List<MathEntity> entities = new ArrayList<>(Arrays.asList(this.entities));

		int i;
		while ((i = indexOf(entities, true)) != -1) calculate(entities, i);

		while ((i = indexOf(entities, false)) != -1) calculate(entities, i);

		return ((MathNum)entities.get(0)).value();
	}

	@Override
	public String toString() {
		return Arrays.stream(entities)
				.map(MathEntity::toString)
				.collect(Collectors.joining(" "));
	}
}
