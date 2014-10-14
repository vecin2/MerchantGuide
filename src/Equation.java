package src;

import java.math.BigDecimal;

public class Equation {
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

	public BigDecimal solve(ConversionTable conversionTable) throws InvalidConversionKey {
		return  decimalConstant.divide(new BigDecimal(coeficient.value(conversionTable)));
	}


}
