package src;

import src.expressions.Galactic;
import src.expressions.GalacticAddition;
import src.expressions.GalacticCurrency;
import src.instructions.ExpressionQuestion;

public class QuestionParser {

	public QuestionParser() {
		super();
	}

	public ExpressionQuestion parse(String instruction) {
		if (!instruction.contains("Credits")) {
			return new ExpressionQuestion(new Galactic(
					getExpression(instruction)));
		} else if (!getExpression(instruction).contains("plus")) {
			return new ExpressionQuestion(
					parseGalacticCurrency(getExpression(instruction)));
		} else {
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
		String stringGalacticCurrency = instruction.split(" is ")[1]
				.split(" \\?")[0];
		return stringGalacticCurrency;
	}

	private ExpressionQuestion parseAddition(String expression) {
		String[] expressionArray = expression.split(" plus ");
		return new ExpressionQuestion(new GalacticAddition(
				parseGalacticCurrency(expressionArray[0]),
				parseGalacticCurrency(expressionArray[1])));

	}
}