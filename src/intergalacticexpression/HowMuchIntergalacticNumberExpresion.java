package src.intergalacticexpression;

import src.IntergalacticNumber;
import src.IntergalacticUnitConverter;
import src.InvalidRomanException;

public class HowMuchIntergalacticNumberExpresion {

	private String stringExpression;

	public HowMuchIntergalacticNumberExpresion(String stringExpression) {
		this.stringExpression = stringExpression;

	}


	public void solve(IntergalacticUnitConverter converter, StringBuilder sb) throws InvalidRomanException {
		IntergalacticNumber intergalacticNumber = new IntergalacticNumber(extractIntergalacticNumber(stringExpression));
		sb.append(intergalacticNumber.getStringNumber() + " is " + intergalacticNumber.value(converter));
		
	}
	private String extractIntergalacticNumber(String note) {
		return extractStringInBetween(note, "how much is", "\\?");
	}
	private String extractStringInBetween(String note, String firstString, String lastString) {
		return note.split(lastString)[0].split(firstString)[1].trim();
	}
	
	

}
