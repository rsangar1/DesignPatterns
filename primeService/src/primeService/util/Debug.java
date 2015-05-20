package primeService.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is debug class common to all the classes
 *
 */
public class Debug {
	FileWriter newFile = null;
	private static volatile Debug debug = null;
	private int DEBUG_VALUE;
	
	/**
	 * A new file is created whenever Debug class is called
	 */
	private Debug(){
		try {
			newFile = new FileWriter("ClientServerLog.txt", true);
		} catch (IOException e) {
			System.out.println("Error while creating file");
		}
	}
	
	/**
	 * This method returns Debug object using singleton pattern
	 * @return Debug
	 */
	public static Debug getInstance(){
		if(debug==null){
			synchronized (Debug.class) {
				if(debug==null){
					debug = new Debug();
				}
			}
		}
		return debug;
	}
	
	/**
	 * This method set the DEBUG_VALUE to the given value.
	 * @param value
	 */
	public void setDebugValue(int value){
		DEBUG_VALUE = value;
	}
	
	/**
	 * This method return the value of DEBUG_LEVEL
	 * @return int
	 */
	private int getDebugValue(){
		return DEBUG_VALUE;
	}
	
	/**
	 * This method prints the message to standard output based on the debug level
	 * @param level
	 * @param debugMessage
	 */
	public void printToLogFile(int level, String debugMessage){
		if(getDebugValue() == level){
			try {
				newFile.append(debugMessage+"\n");
				newFile.flush();
			} catch (IOException e) {
				System.out.println("Exception while writing to file"+e.getMessage());
			}
		}
	}
	
	/** 
	 * Returns a string representation of the Debug object
	 * @return String
	 */
	@Override
	public String toString() {
    	String retValue = "\n Debug Object \n";
    	return retValue;
    }

}
