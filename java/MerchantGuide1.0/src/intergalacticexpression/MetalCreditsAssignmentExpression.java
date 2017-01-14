package src.intergalacticexpression;

import java.math.BigDecimal;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;
import src.MetalCredits;

public class MetalCreditsAssignmentExpression extends IntergalacticExpression {

	private String numberOfCredits;
	private MetalCredits metal;
	private IntergalacticNumber intergalacticNumber;

	public MetalCreditsAssignmentExpression(String stringExpression) {
		// stringExpresion example: glob glob Silver is 34 Credits
		super(stringExpression);
		numberOfCredits = expresionLine.previousWord("Credits");
		metal = new MetalCredits(expresionLine.previousWord("is"));
		intergalacticNumber = new IntergalacticNumber(expresionLine.previousText(metal.toString()));
	}

	@Override
	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidIntergalacticUnitException, InvalidRomanException    {
		converter.addConversion(metal, getRightSideAssignment(converter));

	}

	private String getRightSideAssignment(IntergalacticUnitConverter converter) throws InvalidIntergalacticUnitException, InvalidRomanException  {
		return new BigDecimal(numberOfCredits).divide(new BigDecimal(intergalacticNumber.value(converter))).toString();
	}

}
