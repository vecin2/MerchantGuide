package src;

import java.util.HashMap;

public class IntergalacticNumber {

	private String stringNumber;

	public IntergalacticNumber(String stringNumber) {
		this.stringNumber = stringNumber;
	}

	public int value(IntergalacticUnitConverter converter) throws InvalidRomanException {
		return arabicValue(converter);
	}

	private int arabicValue(IntergalacticUnitConverter converter)
			throws InvalidRomanException {
		return new Roman(convertToRoman(converter)).value();
	}

	private String convertToRoman(IntergalacticUnitConverter converter) {
		String[] intergalacticNumberArray = stringNumber.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String intergalacticSymbol : intergalacticNumberArray) {
			sb.append(converter.get(intergalacticSymbol));
		}
		return sb.toString();
	}

	public String getStringNumber() {
		return stringNumber;
	}
}