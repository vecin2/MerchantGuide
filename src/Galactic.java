package src;

public class Galactic implements Instruction {
	String stringGalactic;
	String[] galacticDigits;
	ConversionTable conversationTable;

	public Galactic(String stringGalactic) {
		this.stringGalactic = stringGalactic;
		this.galacticDigits = stringGalactic.split(" ");
	}

	public static Galactic build(String stringGalactic) {
		return new Galactic( stringGalactic);
	}
	public static Galactic parse(String instruction){
		return new Galactic(getAskedVariable(instruction));
	}
	private static String getAskedVariable(String question) {
		return question.split(" is ")[1].substring(0, question.split(" is ")[1].length() - 2);
	}
	public String toRoman(ConversionTable conversionTable)
			throws InvalidConversionKey {
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

	public int value(ConversionTable conversionTable)
			throws InvalidConversionKey {
		return Roman.build(toRoman(conversionTable)).value();
	}

	@Override
	public String run(ConversionTable conversionTable) {
		try {
			return getStringValue() + " is " + value(conversionTable);
		} catch (InvalidConversionKey e) {
			e.printStackTrace();
		}
		return null;
	}


}
