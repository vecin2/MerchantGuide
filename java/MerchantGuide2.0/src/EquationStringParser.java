package src;

import src.expressions.Galactic;
import src.instructions.Instruction;


/*It parses string with the form of 'glob glob Silver is 34 Credits'*/
public class EquationStringParser {

	public Instruction parse(String stringEquation){
		int constant = getConstant(stringEquation);
		String coeficient = getCoeficient(stringEquation);
		String variable = getVariable(stringEquation);
		return new Equation(Galactic.build(coeficient), variable, constant);
	}

	private String getVariable(String stringEquation){
		return getLeftPart(stringEquation).replaceFirst(
				getCoeficient(stringEquation), "").trim();
	}

	private String getCoeficient(String stringEquation) {
		String leftPart[] = getLeftPart(stringEquation).split(" ");
		String currency = leftPart[leftPart.length-1];
		return getLeftPart(stringEquation).replace(currency, "").trim();
	}

	private int getConstant(String stringEquation) {
		return Integer.parseInt(getRightPart(stringEquation).split(" ")[0]);
	}

	private String getRightPart(String stringEquation) {
		return stringEquation.split(" is ")[1];
	}

	private String getLeftPart(String stringEquation) {
		return stringEquation.split(" is ")[0];
	}




}
