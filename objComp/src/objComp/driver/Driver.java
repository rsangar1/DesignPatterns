package objComp.driver;

import objComp.fileOperations.FileProcessor;
import objComp.fileOperations.FileProcessorInterface;
import objComp.logger.MyLogger;
import objComp.util.PopulateObjects;
import objComp.util.PopulateObjectsInterface;

/**
 * @author Ramesh
 * Date 04-05-2015
 * Assignment 5
 */
public class Driver {
	/**
	 * @param args
	 * Driver code to handle calls to different classes.
	 * Also to print the output to stdout.
	 */
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();
		String inputFileName = "";
		int numberOfIterations = 0;
		int logger_level = 0;
		try {
			if (args.length != 3) {
				System.err.println("Invalid number of arguments");
				System.exit(1);
			}
			if (args[0] != null) {
				inputFileName = args[0];
			} else {
				System.err
						.println("Error with input file name");
				System.exit(1);
			}
			try {
				numberOfIterations = Integer.parseInt(args[1]);
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid number of iterations entered");
				nfe.printStackTrace();
				System.exit(1);
			}
			try {
				logger_level = Integer.parseInt(args[2]);
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid logger level entered");
				nfe.printStackTrace();
				System.exit(1);
			}
			MyLogger myLogger = MyLogger.getInstance();
			myLogger.setLoggerLevel(logger_level);
			int totalFirstObjects = 0;
			int uniqueFirstObjects = 0;
			int totalSecondObjects = 0;
			int uniqueSecondObjects = 0;
			for(int i=0;i<numberOfIterations;i++){
				FileProcessorInterface fileProcessor = new FileProcessor(inputFileName);
				PopulateObjectsInterface populateObjects = new PopulateObjects(fileProcessor);
				populateObjects.deserObjects();
				totalFirstObjects = populateObjects.countTotalObjectsInMap1();
				uniqueFirstObjects = populateObjects.countUniqueObjectsInMap1();
				totalSecondObjects = populateObjects.countTotalObjectsInMap2();
				uniqueSecondObjects = populateObjects.countUniqueObjectsInMap2();
			}
			System.out.println("Number of non-duplicate First objects: "+uniqueFirstObjects+
							   "\nTotal number of First objects: "+totalFirstObjects
							   +"\nNumber of non-duplicate Second objects: "+uniqueSecondObjects
							   +"\nTotal number of Second objects: "+totalSecondObjects);
			long finishTime = System.currentTimeMillis();
			long millis = (finishTime - startTime)/numberOfIterations;
			System.out.println("Total time: "+(millis)/1000f+" seconds");
		} catch (NullPointerException npe) {
			System.err.println("Tried to access null value.");
			npe.printStackTrace();
		} catch (Exception exception) {
			System.err.println("Exception occured. Try again");
			exception.printStackTrace();
		}finally{
			System.exit(1);
		}
	}
}
