package src.intergalacticexpression;

import src.IntergalacticUnitConverter;

public class IntergalacticRomanNumberAssigmentExpression {

	private String stringExpression;

	public IntergalacticRomanNumberAssigmentExpression(String stringExpression) {
		this.stringExpression = stringExpression;
	}

	public void solve(IntergalacticUnitConverter converter) {
		converter.conversionIntergalacticRomans.put(getLeftSideAssignment(stringExpression), getRightSideAssignment(stringExpression));
		
	}
	private String getRightSideAssignment(String note) {
		return note.split(" is ")[1];
	}

	private String getLeftSideAssignment(String note) {
		return note.split(" is ")[0];
	}

}
