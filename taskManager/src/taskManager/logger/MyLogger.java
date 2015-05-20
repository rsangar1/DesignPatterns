package taskManager.logger;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This is logger class is common to all the classes
 * 
 */
public class MyLogger {
	private FileWriter newFile = null;
	private static volatile MyLogger logger = null;
	private int LOGGER_LEVEL;

	/**
	 * A new file is created only once when MyLogger class is called in Driver
	 */
	private MyLogger() {
		try {
			newFile = new FileWriter("log.txt", true);
		} catch (IOException e) {
			System.out.println("Error while creating file");
		}
	}

	/**
	 * This method returns MyLogger object using singleton pattern
	 * 
	 * @return Debug
	 */
	public static MyLogger getInstance() {
		if (logger == null) {
			synchronized (MyLogger.class) {
				if (logger == null) {
					logger = new MyLogger();
				}
			}
		}
		return logger;
	}

	/**
	 * This method set the LOGGER_LEVEL to the given value.
	 * 
	 * @param value
	 */
	public void setLoggerLevel(int value) {
		LOGGER_LEVEL = value;
	}

	/**
	 * This method return the value of LOGGER_LEVEL
	 * 
	 * @return int
	 */
	private int getLoggerLevel() {
		return LOGGER_LEVEL;
	}

	/**
	 * This method prints the message to file based on the debug level
	 * 
	 * @param level
	 * @param debugMessage
	 */
	public void printToLogFile(int level, String debugMessage) {
		if (getLoggerLevel() == level) {
			try {
				newFile.append(debugMessage + "\n");
				newFile.flush();
			} catch (IOException e) {
				System.out.println("Exception while writing to file"
						+ e.getMessage());
			}
		}
	}

	/**
	 * Returns a string representation of the MyLogger object
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String retValue = "\n MyLogger Object \n";
		return retValue;
	}

}
