package operators;

import Evaluator.Operand;

public class SubtractionOperator extends Operator {
	
	//@Override
			public int priority() {
				return 1;
			}
			
			// 
			//
			public Operand execute( Operand op1, Operand op2) {
				Operand op3 = new Operand( op2.getValue() - op1.getValue());
				return op3;
			}	

}
