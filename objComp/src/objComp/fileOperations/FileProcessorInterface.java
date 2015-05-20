package objComp.fileOperations;

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
	 * This method closes the input file.
	 */
	public void closeInputFile();
	
}
