package operators;

import Evaluator.Operand;

public class ExponentOperator extends Operator {
	//@Override
			public int priority() {
				return 3;
			}
			
			public Operand execute( Operand op1, Operand op2) {
				int base = op2.getValue();
				int power = op1.getValue();
				int result = base;
				for( int i = 0; i < power; i++ ) {
					result = result * base;
					power--;
				}
				Operand op3 = new Operand(result);
				return op3;
			}	
}
