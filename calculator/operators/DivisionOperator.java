package operators;

import Evaluator.Operand;

public class DivisionOperator extends Operator {

	//@Override
	public int priority() {
		return 2;
	}
	
	public Operand execute( Operand op1, Operand op2) {
		int quotient = op2.getValue() / op1.getValue();
		Operand op3 = new Operand( quotient );
		return op3;
	}	
}
