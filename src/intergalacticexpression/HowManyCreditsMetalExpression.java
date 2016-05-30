package src.intergalacticexpression;

import java.math.BigDecimal;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidRomanException;

public class HowManyCreditsMetalExpression {

	private String stringExpression;

	public HowManyCreditsMetalExpression(String stringExpression) {
		this.stringExpression = stringExpression;
	}

	public void solve(IntergalacticUnitConverter converter, StringBuilder sb) throws InvalidRomanException {
		Metal metal = new Metal(extractMetalCurrency(stringExpression));
		IntergalacticNumber intergalacticNumber = new IntergalacticNumber(extractStringInBetween(stringExpression, "how many Credits is", "\\w+ \\?"));
		
		sb.append(metal.getName() + " is " + new BigDecimal(converter.conversionMetalsCredits.get("Silver"))
				.multiply(new BigDecimal(intergalacticNumber.value(converter))) + " Credits");
	}

	public String extractMetalCurrency(String note) {
		return extractStringInBetween(note, "how many Credits is", "\\?");
	}

	public String extractStringInBetween(String note, String firstString, String lastString) {
		return note.split(lastString)[0].split(firstString)[1].trim();
	}





}
