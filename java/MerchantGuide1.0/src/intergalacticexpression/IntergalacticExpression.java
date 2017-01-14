package src.intergalacticexpression;

import src.IntergalacticUnitConverter;
import src.InvalidIntergalacticUnitException;
import src.InvalidRomanException;
import src.utils.Line;

public abstract class IntergalacticExpression {

	protected Line expresionLine;

	public IntergalacticExpression(String stringExpression) {
		this.expresionLine = new Line(stringExpression);
	}

	public abstract void solve(IntergalacticUnitConverter converter, StringBuilder sb)
			throws InvalidRomanException, InvalidIntergalacticUnitException;

}