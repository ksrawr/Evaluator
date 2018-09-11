package operators;

import Evaluator.Operand;

public class MultiplicationOperator extends Operator {

	//@Override
	public int priority() {
		return 2;
	}
	
	public Operand execute( Operand op1, Operand op2) {
		Operand op3 = new Operand( op1.getValue() * op2.getValue() );
		return op3;
	}	

}
