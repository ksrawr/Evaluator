package Evaluator;

import operators.Operator;
//import operators.HashMap;
import java.util.*;

public class Evaluator {
  private Stack<Operand> operandStack;
  private Stack<Operator> operatorStack;

  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "()+-*^/ ";

  public Evaluator() {
    operandStack = new Stack<>();
    operatorStack = new Stack<>();
  }

  public int eval( String expression ) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators

    //  Operator is abstract - this will need to be fixed:


    while ( this.tokenizer.hasMoreTokens() ) {
      // filter out spaces
      if ( !( token = this.tokenizer.nextToken() ).equals( " " )) {
        // check if token is an operand
        if ( Operand.check( token )) {
          operandStack.push( new Operand( token ));
        } else {
        	// Right parenthesis check to process expression
            if (token == ")") {
          	  if ( !operatorStack.empty()) {
          		  Operator newOperator = Operator.getOperator(token);
              	  while ( (operandStack.size() > 1) && (operatorStack.peek().priority() >= newOperator.priority()) ) {
                  	// note that when we eval the expression 1 - 2 we will
                      // push the 1 then the 2 and then do the subtraction operation
                      // This means that the first number to be popped is the
                      // second operand, not the first operand - see the following code
                  	Operator oldOpr = operatorStack.pop();
                      Operand op1 = operandStack.pop(); 
                      Operand op2 = operandStack.pop(); 
                      operandStack.push(oldOpr.execute(op1, op2));
                      /*
                      if( operatorStack.empty()) {
                      	continue;
                      }*/
                 		}
                    operatorStack.push( newOperator ); 
                    continue;
               }
            }
          if ( ! Operator.check( token )) {
            System.out.println( "*****invalid token******" );
            throw new RuntimeException("*****invalid token******");
          }
          
          //  Operator is abstract - these two lines will need to be fixed:
          // The Operator class should contain an instance of a HashMap,
          // and values will be instances of the Operators.  See Operator class
          // skeleton for an example.
          
          Operator newOperator = Operator.getOperator( token );
          
          // Operator newOperator = new HashMap( token );
          
          
          
          // ERROR: 
          // (1) Condition in while loop cannot by met if nothing gets pushed
          // on to the stack. 
          // (2) Two operands must exist on the Operand stack in order
          // to compute the expression
          //
          // SOLUTION: 
          // (1) Check if stack is empty and if true push operator to the stack.    
          // (2) Check if there are more than 2 elements on the stack
          /*if ( operatorStack.isEmpty() ) {
              operatorStack.push( newOperator );
              continue;
          }*/
          //System.out.println(operatorStack.peek().priority());
          System.out.println(newOperator.priority());
          if ( !operatorStack.empty()) {
        	  while ( (operandStack.size() > 1) && (operatorStack.peek().priority() >= newOperator.priority()) ) {
            	// note that when we eval the expression 1 - 2 we will
                // push the 1 then the 2 and then do the subtraction operation
                // This means that the first number to be popped is the
                // second operand, not the first operand - see the following code
            	Operator oldOpr = operatorStack.pop();
                Operand op1 = operandStack.pop(); 
                Operand op2 = operandStack.pop(); 
                operandStack.push(oldOpr.execute(op1, op2));
                /*
                if( operatorStack.empty()) {
                	continue;
                }*/
           		}
              operatorStack.push( newOperator ); 
              continue;
         }
         operatorStack.push( newOperator );
        }
       }
     }

    // Control gets here when we've picked up all of the tokens; you must add
    // code to complete the evaluation - consider how the code given here
    // will evaluate the expression 1+2*3
    // When we have no more tokens to scan, the operand stack will contain 1 2
    // and the operator stack will have + * with 2 and * on the top;
    // In order to complete the evaluation we must empty the stacks (except
    // the init operator on the operator stack); that is, we should keep
    // evaluating the operator stack until it only contains the init operator;
    // Suggestion: create a method that takes an operator as argument and
    // then executes the while loop.
    while ( !operatorStack.empty()) {
    	Operator currOpr = operatorStack.pop();
    	Operand op1 = operandStack.pop();
    	Operand op2 = operandStack.pop();
    	operandStack.push(currOpr.execute(op1, op2));
    }
    
    return operandStack.pop().getValue();
  }
  // Evaluate all the String tokens to complete evaluation
  // of expression
  /*
  public void evalTokens(Operator currOpr, Operand op1, Operand op2 ) {
	  while (operatorStack.peek().priority() > 0) {
		  currOpr = operatorStack.pop();
		  op2 = operandStack.pop();
		  op1 = operandStack.pop();
		  operandStack.push( currOpr.execute(op1, op2));
	  }
  }
  */
}
