package src;

public class GalaxyAgenda {
	ConversionTable conversionTable;

	public GalaxyAgenda() {
		conversionTable = new ConversionTable();
	}

	public GalaxyAgenda(ConversionTable conversationTable) {
		this.conversionTable = conversationTable;
	}

	public void addNote(String note) throws InvalidConversionKey {
			AgendaParser.parseInstruction(note).run(conversionTable);
	}

	

}
