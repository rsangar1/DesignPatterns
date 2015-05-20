package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.logger.MyLogger;
import taskManager.tabs.Process;
import taskManager.util.FileProcessorInterface;

/**
 * Process tab observer
 */
public class ProcessesTab implements Observer, DisplayFile {
	private List<Process> processesList = null;
	private FileProcessorInterface fileProcessor = null;
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param fileProcessor
	 */
	public ProcessesTab(FileProcessorInterface fileProcessor) {
		logger.printToLogFile(2, "ProcessTab constructor");
		this.fileProcessor = fileProcessor;
	}

	/**
	 * This method gets the updated string to process
	 */
	public void update(String strIn) {
		logger.printToLogFile(3, "ProcessTab: update()");
		processInputString(strIn);
	}

	/**
	 * @param strIn
	 * This method processes the input string
	 */
	private void processInputString(String strIn) {
		logger.printToLogFile(3, "ProcessTab: processInputString()");
		processesList = new ArrayList<Process>();
		Process newProcess = null;
		String[] processes = strIn.substring("Processes".length() + 1).split(
				"-");
		String[] processDetails = null;
		for (String process : processes) {
			processDetails = process.split(":");
			newProcess = new Process();
			newProcess.setPid(processDetails[0]);
			newProcess.setCommand(processDetails[1]);
			newProcess.setUser(processDetails[2]);
			newProcess.setCpu(processDetails[3]);
			newProcess.setMemory(processDetails[4]);
			processesList.add(newProcess);
		}
		display();
	}

	/**
	 * This method writes the contents to the file
	 */
	public void display() {
		logger.printToLogFile(3, "ProcessTab: display()");
		fileProcessor.writeToFile("---PROCESSES---\n");
		fileProcessor.writeToFile("  PID COMMAND         USER     %CPU %MEM\n");
		for (Process process : processesList) {
			fileProcessor.writeToFile(process.toString());
		}
		fileProcessor.writeToFile("\n");
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "Process object";
	}
}
