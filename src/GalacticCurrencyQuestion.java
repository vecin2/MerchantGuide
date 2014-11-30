package src;

import java.text.DecimalFormat;

public class GalacticCurrencyQuestion implements Instruction {
	public GalacticCurrency galacticCurrency;

	public GalacticCurrencyQuestion() {
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