package src.intergalacticexpression;

import src.IntergalacticUnitConverter;

public class InvalidIntergalacticExpression extends IntergalacticExpression {

	public InvalidIntergalacticExpression(String stringExpression) {
		// example stringExpression:how much wood could a woodchuck chuck if a
		// woodchuck could chuck wood ?
		super(stringExpression);
	}

	@Override
	public void solve(IntergalacticUnitConverter converter, StringBuilder sb)  {
		sb.append("I have no idea what you are talking about\n");

	}

}
