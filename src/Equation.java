package src;

import java.math.BigDecimal;

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
		return decimalConstant.divide(new BigDecimal(coeficient
				.value(conversionTable)));
	}

	public void run(ConversionTable conversionTable) {
		try {
			conversionTable.put(getVariable(), solve(conversionTable).toString());
		} catch (InvalidConversionKey e) {
			e.printStackTrace();
		}
	}

}
