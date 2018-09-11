package operators;

import Evaluator.Operand;

public class AdditionOperator extends Operator{
	
	//@Override
		public int priority() {
			return 1;
		}
		
		public Operand execute( Operand op1, Operand op2) {
			Operand op3 = new Operand( op1.getValue() + op2.getValue() );
			return op3;
		}	

}
