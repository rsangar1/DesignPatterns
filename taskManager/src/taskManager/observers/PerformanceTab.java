package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.logger.MyLogger;
import taskManager.tabs.Performance;
import taskManager.util.FileProcessorInterface;

/**
 * This is Performance tab implementation
 */
public class PerformanceTab implements Observer, DisplayFile {
	private List<Performance> performanceList = null;
	private FileProcessorInterface fileProcessor = null;
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param fileProcessor
	 */
	public PerformanceTab(FileProcessorInterface fileProcessor) {
		logger.printToLogFile(2, "PerformanceTab constructor");
		this.fileProcessor = fileProcessor;
	}

	/**
	 * This method updates the string
	 */
	public void update(String strIn) {
		logger.printToLogFile(3, "PerformanceTab: update()");
		processInputString(strIn);
	}

	/**
	 * @param strIn
	 * Processes the string of performance tab
	 */
	private void processInputString(String strIn) {
		logger.printToLogFile(3, "PerformanceTab: processInputString()");
		performanceList = new ArrayList<Performance>();
		Performance newPerformance = null;
		String[] performances = strIn.substring("Performance".length() + 1)
				.split("-");
		String[] performanceDetails = null;
		for (String performance : performances) {
			performanceDetails = performance.split(":");
			newPerformance = new Performance();
			newPerformance.setTotalMemory(performanceDetails[0]);
			newPerformance.setUsedMemory(performanceDetails[1]);
			newPerformance.setFreeMemory(performanceDetails[2]);
			newPerformance.setCachedMemory(performanceDetails[3]);
			newPerformance.setCpuIdle(performanceDetails[4]);
			newPerformance.setUserLevel(performanceDetails[5]);
			newPerformance.setSystemLevel(performanceDetails[6]);
			performanceList.add(newPerformance);
		}
		display();
	}

	/**
	 * This method is used to display the contents to file
	 */
	public void display() {
		logger.printToLogFile(3, "PerformanceTab: display()");
		fileProcessor.writeToFile("---PERFORMANCE---\n");
		for (Performance performance : performanceList) {
			fileProcessor.writeToFile(performance.toString());
		}
		fileProcessor.writeToFile("\n");
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "Performance object";
	}

}
