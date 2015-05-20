package taskManager.util;

/**
 * This interface contains basic file operations
 * 
 */
public interface FileProcessorInterface {
	/**
	 * @return String This method return each line at a time
	 */
	public String readLineFromFile();

	/**
	 * @param outString
	 * This method writes the input string to the file
	 */
	public void writeToFile(String outString);
}
