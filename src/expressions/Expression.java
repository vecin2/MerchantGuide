package src.expressions;

import java.math.BigDecimal;

import src.ConversionTable;
import src.InvalidConversionKey;

public interface Expression {
	public BigDecimal value(ConversionTable conversionTable)throws InvalidConversionKey;
	public String stringValue(ConversionTable conversionTable)throws InvalidConversionKey;

}
