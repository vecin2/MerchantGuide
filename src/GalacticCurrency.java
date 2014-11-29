package src;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import src.expressions.Expression;

public class GalacticCurrency implements Instruction, Expression {
	private Galactic galactic;
	private String currency;

	public GalacticCurrency(String galactic, String currency) {
		this.galactic = Galactic.build(galactic);
		this.currency = currency;
	}

	public static Expression parse(String instruction) {
		QuestionParser questionParser = new QuestionParser();
		return questionParser.parse(instruction);
	}


	public String getGalacticString() {
		return galactic.getStringValue();
	}

	public String getCurrency() {
		return currency;
	}

	@Override
	public boolean equals(Object object) {
		GalacticCurrency tocompare = (GalacticCurrency) object;
		return tocompare.galactic.equals(galactic)
				&& tocompare.currency.equals(currency);
	}

	@Override
	public String toString() {
		return this.galactic.toString() + ", " + currency;
	}

	public BigDecimal value(ConversionTable conversationTable)
			throws InvalidConversionKey {
		return new BigDecimal(galactic.value(conversationTable))
				.multiply(new BigDecimal(conversationTable.get(currency)));
	}

	@Override
	public String run(ConversionTable conversionTable) {
		DecimalFormat format = new DecimalFormat("#.##");
		try {
			return getGalacticString() + " " + getCurrency() + " is "
					+ format.format(value(conversionTable)) + " Credits";
		} catch (InvalidConversionKey e) {
			e.printStackTrace();
		}
		return null;
	}
}
