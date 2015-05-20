package taskManager.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is debug class common to all the classes
 *
 */
public class MyLogger {
	FileWriter newFile = null;
	private static volatile MyLogger logger = null;
	private int LOGGER_LEVEL;
	
	/**
	 * A new file is created whenever Debug class is called
	 */
	private MyLogger(){
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
	public static MyLogger getInstance(){
		if(logger==null){
			synchronized (MyLogger.class) {
				if(logger==null){
					logger = new MyLogger();
				}
			}
		}
		return logger;
	}
	
	/**
	 * This method set the LOGGER_LEVEL to the given value.
	 * @param value
	 */
	public void setLoggerLevel(int value){
		LOGGER_LEVEL = value;
	}
	
	/**
	 * This method return the value of DEBUG_LEVEL
	 * @return int
	 */
	private int getLoggerLevel(){
		return LOGGER_LEVEL;
	}
	
	/**
	 * This method prints the message to standard output based on the debug level
	 * @param level
	 * @param debugMessage
	 */
	public void printToLogFile(int level, String debugMessage){
		if(getLoggerLevel() == level){
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

