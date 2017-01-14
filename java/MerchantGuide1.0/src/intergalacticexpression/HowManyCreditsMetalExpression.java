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

	private MetalCredits metalCredits;
	private IntergalacticNumber intergalacticNumber;

	public HowManyCreditsMetalExpression(String stringExpression) {
		// stringExpresion example: how many Credits is glob prok Silver ?
		super(stringExpression);
		metalCredits = new MetalCredits(extractMetalCreditsExpression().lastWord());
		intergalacticNumber = new IntergalacticNumber(extractMetalCreditsExpression().removeLastWord().toString());
	}
	
	public Line extractMetalCreditsExpression() {
		return expresionLine.wordsInBetween("how many Credits is", "\\?");
	}

	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidRomanException, InvalidIntergalacticUnitException {
		DecimalFormat format = new DecimalFormat("#.##");
		sb.append(extractMetalCreditsExpression() + " is "
				+ format.format(metalCredits.value(converter).multiply(new BigDecimal(intergalacticNumber.value(converter)))) + " Credits\n");
	}

}
