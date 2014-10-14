package src;

import java.text.DecimalFormat;

public class ConversionQuestionAnswerer {

	private ConversionTable conversionTable;

	public ConversionQuestionAnswerer(ConversionTable conversionTable) {
		this.conversionTable = conversionTable;
	}

	public String answer(String question) throws InvalidConversionKey {
		if (question.split(" is ").length < 2) {
			return "I have no idea what you are talking about";
		} else if (!question.contains("Credits")) {
			Galactic g = Galactic.build(getAskedVariable(question));
			return g.getStringValue() + " is " + g.value(conversionTable);
		} else {
			String galacticExpression = question.split(" is ")[1].split(" \\?")[0];
			EquationStringParser parser = new EquationStringParser();
			GalacticCurrency galacticCurrency = parser.parseGalacticCurrency(galacticExpression);
			DecimalFormat format = new DecimalFormat("#.##");
			return galacticExpression + " is "
					+ format.format(galacticCurrency.value(conversionTable))+ " Credits";
		}
	}

	private String getAskedVariable(String question) {
		return question.split(" is ")[1].substring(0, question.split(" is ")[1].length() - 2);
	}

}
