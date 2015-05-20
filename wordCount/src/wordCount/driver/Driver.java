package wordCount.driver;

import wordCount.treesForStrings.DataTree;
import wordCount.treesForStrings.DataTreeInterface;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessorInterface;
import wordCount.util.MyLogger;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.Visitor;
import wordCount.visitors.WordCountVisitor;

/**
 * @author Ramesh
 * Driver code to create elements and pass elements
 *
 */
public class Driver {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputFileName = "";
		String outputFileName = "";
		int numberOfIterations = 0;
		int logger_level = 0;
		try {
			if (args.length != 4) {
				System.err.println("Invalid number of arguments");
				System.exit(1);
			}

			if (args[0] != null && args[1] != null) {
				inputFileName = args[0];
				outputFileName = args[1];
			} else {
				System.err
						.println("Error with input and output file names");
				System.exit(1);
			}

			try {
				numberOfIterations = Integer.parseInt(args[2]);
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid number of iterations entered");
				System.exit(1);
			}

			try {
				logger_level = Integer.parseInt(args[3]);
			} catch (NumberFormatException nfe) {
				System.err.println("Invalid logger level entered");
				System.exit(1);
			}

			MyLogger myLogger = MyLogger.getInstance();
			myLogger.setLoggerLevel(logger_level);
			
			long startTime = System.currentTimeMillis();

			for(int count=0;count<numberOfIterations;count++) {
				//creating the files using file processor
				FileProcessorInterface fileProcessor = new FileProcessor(
						inputFileName, outputFileName);
				//creating the element
				DataTreeInterface dataTree = new DataTree();
				//creating the visitors
				Visitor populateTreeVisitor = new PopulateTreeVisitor(
						fileProcessor);
				Visitor wordCountVisitor = new WordCountVisitor(fileProcessor);

				dataTree.accept(populateTreeVisitor);
				dataTree.accept(wordCountVisitor);
			}
			//calculating the total time for each iteration
			long finishTime = System.currentTimeMillis();
			long totalTime = (finishTime - startTime) / numberOfIterations;
			System.out.println("Time per each iteration: " + totalTime);
		} catch (NullPointerException npe) {
			System.err.println("Tried to access null value.");
		} catch (Exception exception) {
			System.err.println("Exception occured. Try again");
		}
	}
}
