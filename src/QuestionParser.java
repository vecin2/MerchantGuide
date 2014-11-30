package src;

import src.GalacticAddition;
import src.expressions.Expression;

public class QuestionParser {
	
	public QuestionParser() {
		super();
	}

	public  Expression parse(String instruction) {
		if(!getExpression(instruction).contains("plus")){
			return parseGalacticCurrency(getExpression(instruction));
		}
		else{
			return parseAddition(getExpression(instruction));
		}
	}

	private GalacticCurrency parseGalacticCurrency(String expression) {
		String[] galacticCurrencyArray = expression.split(" ");
		String currency = galacticCurrencyArray[galacticCurrencyArray.length - 1];
		String galactic = expression.replace(currency, "").trim();
		return new GalacticCurrency(galactic, currency);
	}
	protected static String getExpression(String instruction) {
		String stringGalacticCurrency =  instruction.split(" is ")[1].split(" \\?")[0];
		return stringGalacticCurrency;
	}



	private Expression parseAddition(String expression) {
		String[] expressionArray = expression.split(" plus ");
		return new GalacticAddition(parseGalacticCurrency(expressionArray[0]), parseGalacticCurrency(expressionArray[1]));
		
	}

}