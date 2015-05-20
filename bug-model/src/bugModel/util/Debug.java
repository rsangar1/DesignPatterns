package bugModel.util;

public class Debug {
	private static int DEBUG_VALUE;
	
	/**
	 * This method set the DEBUG_VALUE to the given value.
	 * @param value
	 */
	public static void setDebugValue(int value){
		DEBUG_VALUE = value;
	}
	
	/**
	 * This method return the value of DEBUG_LEVEL
	 * @return int
	 */
	private static int getDebugValue(){
		return DEBUG_VALUE;
	}
	
	/**
	 * This method prints the message to standard output based on the debug level
	 * @param level
	 * @param debugMessage
	 */
	public static void printToStdout(int level, String debugMessage){
		if(getDebugValue() == level){
			System.out.println(debugMessage);
		}
	}
	
	/* 
	 * Returns a string representation of the Debug object
	 * @return String
	 */
	@Override
	public String toString() {
    	String retValue = "\n Debug Object \n";
    	return retValue;
    }
}
