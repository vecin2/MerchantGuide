package src.intergalacticexpression;

import java.util.List;

import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;

public class ExpressionSet extends IntergalacticExpression{
	public ExpressionSet(String stringExpression) {
		super(stringExpression);
	}

	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidRomanException, InvalidIntergalacticUnitException {
		List<String> expressionLines = expresionLine.getLines();
		for(String line: expressionLines){
			makeExpression(line).solve(converter, sb);
		}
	}

	private IntergalacticExpression makeExpression(String instruction) {
		IntergalacticExpression expression;
		if (instruction.contains("how much is")) {
			expression = new HowMuchIntergalacticNumberExpresion(instruction);
		} else if (instruction.contains("how many Credits is")) {
			expression = new HowManyCreditsMetalExpression(instruction);

		} else if (instruction.contains("Credits")) {
			expression = new MetalCreditsAssignmentExpression(instruction);

		} else if (instruction.contains("is")) {
			expression = new IntergalacticRomanNumberAssigmentExpression(instruction);

		} else {
			expression = new InvalidIntergalacticExpression(instruction);
		}
		return expression;
	}


}
