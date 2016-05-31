package src.intergalacticexpression;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;

public class HowMuchIntergalacticNumberExpresion extends IntergalacticExpression {

	private IntergalacticNumber intergalacticNumber;

	public HowMuchIntergalacticNumberExpresion(String stringExpression) {
		// example stringExpression: how much is pish tegj glob glob ?
		super(stringExpression);
		intergalacticNumber = new IntergalacticNumber(expresionLine.wordsInBetween("how much is", "\\?"));
	}

	@Override
	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidRomanException, InvalidIntergalacticUnitException {
		sb.append(intergalacticNumber.toString() + " is " + intergalacticNumber.value(converter) + "\n");
	}

}
