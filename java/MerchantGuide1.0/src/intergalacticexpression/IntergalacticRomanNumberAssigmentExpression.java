package src.intergalacticexpression;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidRomanException;

public class IntergalacticRomanNumberAssigmentExpression extends IntergalacticExpression {

	private IntergalacticNumber intergalacticNumber;
	private String romanSymbol;

	public IntergalacticRomanNumberAssigmentExpression(String stringExpression) {
		// exmaple stringExpression: glob is I
		super(stringExpression);
		intergalacticNumber = new IntergalacticNumber(expresionLine.previousText(" is "));
		romanSymbol = expresionLine.textAfter(" is ");
	}

	@Override
	public void solve(IntergalacticUnitConverter converter, StringBuilder sb) throws InvalidRomanException {
		converter.addConversion(intergalacticNumber, romanSymbol);

	}

}
