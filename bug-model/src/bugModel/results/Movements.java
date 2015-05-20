package bugModel.results;

import bugModel.util.Debug;

/**
 * @author Ramesh Sangaraju
 * This is user defined class to define code for bug movements.
 *
 */
public class Movements {
	int intCode;
	String stringCode;
	/**
	 * This constructor set the code value
	 * @param code
	 */
	public Movements(int code){
		Debug.printToStdout(4, "constructor is called : Movements class");
		this.intCode = code;
	}
	
	//The movement code might change to String and hence following constructor is defined
	/**
	 * This constructor set the code value
	 * @param code
	 */
	public Movements(String code){
		Debug.printToStdout(4, "constructor is called : Movements class");
		this.stringCode = code;
	}
	
	
	/* 
	 * This method gives string representation of Movements object
	 * @return String
	 */
	public String toString() {
		Debug.printToStdout(3, "method is called: Movements.toString");
    	String retValue = "\n Movements Object \n";
    	return retValue;
    }
}
