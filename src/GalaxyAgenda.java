package src;


public class GalaxyAgenda {
	ConversionTable conversionTable;

	public GalaxyAgenda() {
		conversionTable = new ConversionTable();
	}

	public GalaxyAgenda(ConversionTable conversationTable) {
		this.conversionTable = conversationTable;
	}

	public String run(String note) {
		return AgendaParser.parseInstruction(note).run(conversionTable);
	}

	

	


}
