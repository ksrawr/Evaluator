package Evaluator;

public class Operand {

  public Operand( String token ) {
	  // One way you can do this is:
      //    Integer.parseInt();
	  this.value = Integer.parseInt( token );
	  System.out.println("tokenVal:" + this.value);
  }

  public Operand( int value ) {
	  this.value = value;
  }

  public int getValue() {
	  System.out.println(value);
      return value;
  }

  // Operand should hold the converted tokens into numbers
  // Create exception that returns false when the token 
  // cannot be parse as an integer if it can return true
  public static boolean check( String token ) {
	  try {
		  Integer.parseInt( token );
	  }
	  catch (NumberFormatException e) {
		  return false;
	  }
	  System.out.println("Is OPERAND!");
      return true;
  }
  private int value;
}
