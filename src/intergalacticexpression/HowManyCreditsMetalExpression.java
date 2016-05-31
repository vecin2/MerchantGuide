package src.intergalacticexpression;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;
import src.MetalCredits;
import src.utils.Line;

public class HowManyCreditsMetalExpression extends IntergalacticExpression {

	private MetalCredits metal;
	private IntergalacticNumber intergalacticNumber;

	public HowManyCreditsMetalExpression(String stringExpression) {
		// stringExpresion example: how many Credits is glob prok Silver ?
		super(stringExpression);
		metal = new MetalCredits(extractMetalName());
		intergalacticNumber = new IntergalacticNumber(expresionLine.wordsInBetween("how many Credits is", "\\w+ \\?"));
	}

	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidRomanException, InvalidIntergalacticUnitException {
		DecimalFormat format = new DecimalFormat("#.##");
		sb.append(extractMetalExpression() + " is "
				+ format.format(metal.value(converter).multiply(new BigDecimal(intergalacticNumber.value(converter)))) + " Credits\n");
	}

	private String extractMetalName() {
		return new Line(extractMetalExpression()).lastWord();
	}

	public String extractMetalExpression() {
		return expresionLine.wordsInBetween("how many Credits is", "\\?");
	}

}
