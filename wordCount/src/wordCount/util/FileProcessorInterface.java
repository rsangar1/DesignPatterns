package wordCount.util;

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

	/**
	 * This method closes the input file.
	 */
	public void closeInputFile();
	
	/**
	 * This method closes the output file
	 */
	public void closeOutputFile();
}
