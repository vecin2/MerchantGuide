package src;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class GalacticCurrency implements Instruction{
	private Galactic galactic;
	private String currency;

	public GalacticCurrency(String galactic, String currency) {
		this.galactic = Galactic.build(galactic);
		this.currency = currency;
	}

	public String getGalacticString() {
		return galactic.getStringValue();
	}

	public String getCurrency() {
		return currency;
	}
	@Override
	public boolean equals(Object object){
		GalacticCurrency tocompare = (GalacticCurrency)object;
		return tocompare.galactic.equals(galactic) && tocompare.currency.equals(currency);
	}
	@Override
	public String toString(){
		return this.galactic.toString() +", "+ currency;
	}

	public BigDecimal value(ConversionTable conversationTable) throws InvalidConversionKey {
		return new BigDecimal(galactic.value(conversationTable)).multiply(new BigDecimal(conversationTable.get(currency)));
	}

	@Override
	public void run(ConversionTable conversionTable) {
		// TODO Auto-generated method stub
		
	}

	public String getSolvedString(ConversionTable conversionTable) throws InvalidConversionKey {
		DecimalFormat format = new DecimalFormat("#.##");
		return getGalacticString() + " " + getCurrency() + " is "
				+ format.format(value(conversionTable))+ " Credits";
		}

}
