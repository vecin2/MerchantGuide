package src;


public class Galactic {
	String stringGalactic;
	String[] galacticDigits;
	ConversionTable conversationTable;

	public Galactic(String stringGalactic) {
		this.stringGalactic = stringGalactic;
		this.galacticDigits = stringGalactic.split(" ");
	}

	public static Galactic build(String stringGalactic) {
		return new Galactic(stringGalactic);
	}

	public String toRoman(ConversionTable conversionTable) throws InvalidConversionKey {
		String StringString = "";
		for (String digit : galacticDigits) {
			StringString += " " + conversionTable.get(digit);
		}
		if (!StringString.isEmpty()) {
			StringString = StringString.substring(1);
		}
		return StringString;
	}

	public String getStringValue() {
		return stringGalactic;
	}

	@Override
	public String toString() {
		return stringGalactic;
	}

	@Override
	public boolean equals(Object object) {
		Galactic toCompare = (Galactic) object;
		return stringGalactic.equals(toCompare.stringGalactic);
	}

	public int value(ConversionTable conversionTable) throws InvalidConversionKey {
		return Roman.build(toRoman(conversionTable)).value();
	}

}
