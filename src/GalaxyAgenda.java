package src;

import java.text.DecimalFormat;


public class GalaxyAgenda {
	ConversionTable conversionTable;

	public GalaxyAgenda() {
		conversionTable = new ConversionTable();
	}

	public GalaxyAgenda(ConversionTable conversationTable) {
		this.conversionTable = conversationTable;
	}

	public void addNote(String note) throws InvalidConversionKey {
			ConversationNotePersister persister = new ConversationNotePersister(conversionTable);
			persister.saveNote(note);
	}
	public String ask(String question) throws InvalidConversionKey {
			ConversionQuestionAnswerer answerer = new ConversionQuestionAnswerer(conversionTable);
			return answerer.answer(question);
	}
}
