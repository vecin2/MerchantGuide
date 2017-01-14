package src;

import java.math.BigDecimal;

import src.expressions.Galactic;
import src.instructions.Instruction;

public class Equation implements Instruction {
	Galactic coeficient;
	int constant;
	String variable;
	BigDecimal decimalConstant;

	public Equation(Galactic coeficient, String variable, int constant) {
		this.coeficient = coeficient;
		this.variable = variable;
		this.constant = constant;
		this.decimalConstant = new BigDecimal(constant);
	}

	public Galactic getCoeficient() {
		return coeficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getConstant() {
		return constant;
	}

	public BigDecimal getConstantDecimal() {
		return decimalConstant;
	}

	public BigDecimal solve(ConversionTable conversionTable)
			throws InvalidConversionKey {
		return decimalConstant.divide(coeficient.value(conversionTable));
	}

	public String run(ConversionTable conversionTable) {
		try {
			return conversionTable.put(getVariable(), solve(conversionTable).toString());
		} catch (InvalidConversionKey e) {
			e.printStackTrace();
		}
		return null;
	}

}
