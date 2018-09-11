package operators;

import Evaluator.Operand;

public class LeftParOperator extends Operator {
	//@Override
	public int priority() {
		return 5;
	}
	// Parenthesis don't do anything...
	public Operand execute (Operand op1, Operand op2) {
		return null;
	}
}
