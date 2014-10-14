package src;

public class ConversationNotePersister {

	private ConversionTable conversionTable;

	public ConversationNotePersister(ConversionTable conversionTable) {
		this.conversionTable = conversionTable;
	}

	public void saveNote(String note) throws InvalidConversionKey {
		if (!note.contains("Credits")) {
			String[] arrayNote = note.split(" is ");
			this.conversionTable.put(arrayNote[0], arrayNote[1]);
		}
		else {
			EquationStringParser parser = new EquationStringParser();
			Equation equation = parser.parse(note, conversionTable);
			this.conversionTable.put(equation.getVariable(), equation.solve(conversionTable).toString());
		}
	}

}
