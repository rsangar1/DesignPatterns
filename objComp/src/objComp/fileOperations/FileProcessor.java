package objComp.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;

import objComp.logger.MyLogger;

/**
 * This class is useful to do basic file operations and it is reusable utility
 * class
 * 
 */
public class FileProcessor implements FileProcessorInterface{
	private FileReader inputFile = null;
	private BufferedReader bufferedReader= null;
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param inputFileName
	 * @param outputFileName
	 * Creating file writer and file reader objects
	 */
	public FileProcessor(String inputFileName) {
		logger.printToLogFile(2, "FileProcessor constructor");
		createFiles(inputFileName);
		bufferedReader = new BufferedReader(inputFile);
	}

	/**
	 * @param inputFileName
	 * @param outputFileName
	 * This method creates the filewriter and file reader.
	 */
	private void createFiles(String inputFileName) {
		logger.printToLogFile(3, "FileProcessor: createFiles()");
		try{
			inputFile = new FileReader(inputFileName);
		}catch(Exception ioe){
			System.err.println("Exception while creating file");
		}
	}

	/**
	 * This method return each line at a time
	 */
	public String readLineFromFile() {
		logger.printToLogFile(3, "FileProcessor: readLineFromFile()");
		String str = "";
		try {
			str = bufferedReader.readLine();
		} catch (Exception e) {
			System.err.println("Error while reading from file");
		}
		return str;
	}

	/**
	 * This method closes the input file resources
	 */
	public void closeInputFile() {
		logger.printToLogFile(3, "FileProcessor: closeFileSources()");
		try{
			inputFile.close();
		}catch(Exception e){
			System.err.println("Error while closing input file");
		}
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "FileProcessor object";
	}
}
