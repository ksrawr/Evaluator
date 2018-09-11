package operators;

import Evaluator.Operand;
import java.util.*;

public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.
  // ALL subclasses of operator MUST be in their own file.
  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  // HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );

  /* Note you may use "static block" to initialize the hash map
  ie.
    static {
    	...
    }
  */static HashMap<String, Object> operators;
	static {
		operators = new HashMap<String, Object>();
		operators.put("+", new AdditionOperator());
		operators.put("-", new SubtractionOperator());
		operators.put("*", new MultiplicationOperator());
		operators.put("/", new DivisionOperator());
		operators.put("^", new ExponentOperator());
		operators.put("(", new LeftParOperator());
	}
    
  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

  public static boolean check( String token ) {
	  // Note: Use HashMap method "hashMapName.containsKey()" to check in 
	  // order to avoid using multiple if-statements or switch statements.
      return operators.containsKey(token);
  }
  
  public static Operator getOperator( String token ) {
	  // "return operators.get(token)" // ILLEGAL cannot convert Object to Operator
	  return (Operator) operators.get(token);
  }
}
