package src.intergalacticexpression;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidRomanException;
import src.Roman;

public class MetalCreditsAssignmentExpression {

	private String stringExpression;

	public MetalCreditsAssignmentExpression(String stringExpression) {
		this.stringExpression = stringExpression;
	}

	public void solve(IntergalacticUnitConverter converter) throws NumberFormatException, InvalidRomanException {
		List<String> noteWords = Arrays.asList(stringExpression.split(" "));
		String numberOfCredits = noteWords.get(noteWords.indexOf("Credits") - 1);
		Metal metal = new Metal(extractMetalCurrency(noteWords));
		IntergalacticNumber intergalacticNumber = new IntergalacticNumber(extractIntergalacticNumber(metal.getName()));
		converter.conversionMetalsCredits.put(metal.getName(),
				Integer.parseInt(numberOfCredits) /intergalacticNumber.value(converter) + "");

	}

	private String extractIntergalacticNumber(String metalName) {
		   return stringExpression.split(metalName)[0];
	}

	private String extractMetalCurrency(List<String> noteWords) {
		return noteWords.get(noteWords.indexOf("is") - 1);
		
	}
	public int arabicValue(String intergalacticNumber, HashMap<String, String> conversionIntergalacticRomans) throws InvalidRomanException {
		return new Roman(getRoman(intergalacticNumber, conversionIntergalacticRomans)).value();
	}



	private String getRoman(String intergalacticNumber, HashMap<String, String> conversionIntergalacticRomans) {
		String[] intergalacticNumberArray = intergalacticNumber.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String intergalacticSymbol : intergalacticNumberArray) {
			sb.append(conversionIntergalacticRomans.get(intergalacticSymbol));
		}
		return sb.toString();
	}

	

}
