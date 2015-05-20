package wordCount.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class is useful to do basic file operations and it is reusable utility
 * class
 * 
 */
public class FileProcessor implements FileProcessorInterface{
	private FileReader inputFile = null;
	private FileWriter outputFile = null;
	private BufferedReader bufferedReader= null;
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param inputFileName
	 * @param outputFileName
	 * Creating file writer and file reader objects
	 */
	public FileProcessor(String inputFileName, String outputFileName) {
		logger.printToLogFile(2, "FileProcessor constructor");
		createFiles(inputFileName, outputFileName);
		bufferedReader = new BufferedReader(inputFile);
	}

	/**
	 * @param inputFileName
	 * @param outputFileName
	 * This method creates the filewriter and file reader.
	 */
	private void createFiles(String inputFileName, String outputFileName) {
		logger.printToLogFile(3, "FileProcessor: createFiles()");
		try{
			inputFile = new FileReader(inputFileName);
			outputFile = new FileWriter(outputFileName, true);
		}catch(Exception ioe){
			System.err.println("Exception while creating files");
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
	 * This method closes the output file resources
	 */
	public void closeOutputFile() {
		logger.printToLogFile(3, "FileProcessor: closeFileSources()");
		try{
			outputFile.close();
		}catch(Exception e){
			System.err.println("Error while closing output file");
		}
		
	}

	/**
	 * This method writes the string to the file
	 */
	public void writeToFile(String outString) {
		logger.printToLogFile(1, outString);
		logger.printToLogFile(3, "FileProcessor: writeToFile()");
		try {
			outputFile.append(outString);
			outputFile.flush();
		} catch (Exception exception) {
			System.err.println("Error while writing to file");
		}
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "FileProcessor object";
	}
}
