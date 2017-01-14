package src;

public class IntergalacticNumber {

	private String stringNumber;

	public IntergalacticNumber(String stringNumber) {
		this.stringNumber = stringNumber;
	}

	public int value(IntergalacticUnitConverter converter)
			throws InvalidIntergalacticUnitException, InvalidRomanException {
		return new Roman(convertToRoman(converter)).value();
	}

	private String convertToRoman(IntergalacticUnitConverter converter) throws InvalidIntergalacticUnitException {
		String[] intergalacticNumberArray = stringNumber.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String intergalacticSymbol : intergalacticNumberArray) {
			sb.append(converter.convert(new IntergalacticNumber(intergalacticSymbol)));
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stringNumber == null) ? 0 : stringNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntergalacticNumber other = (IntergalacticNumber) obj;
		if (stringNumber == null) {
			if (other.stringNumber != null)
				return false;
		} else if (!stringNumber.equals(other.stringNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return stringNumber;
	}

}