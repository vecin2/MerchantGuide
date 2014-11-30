package src;

import src.expressions.Expression;

public class GalacticAddition implements Expression {

	private Expression augend;
	private Expression addend;

	public GalacticAddition(Expression augend, Expression addend) {
		this.augend = augend;
		this.addend = addend;
	}

	public Expression getAugend() {
		return augend;
	}
	public Expression getAddend(){
		return addend;
	}

}
