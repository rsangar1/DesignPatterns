package taskManager.subject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;
import taskManager.observers.Observer;
import taskManager.util.FileProcessorInterface;

/**
 * This is Dashboard subject class that will notify all observers based on input
 * string
 */
public class DashboardSubject implements Subject {
	// data structure to maintain list of observers and filters
	private Map<Observer, DashboardFilter> observersMap = null;
	private FileProcessorInterface fileProcessor = null;
	private String inputLine = "";
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param fileProcessor
	 */
	public DashboardSubject(FileProcessorInterface fileProcessor) {
		logger.printToLogFile(2, "DashboardSubject constructor");
		this.fileProcessor = fileProcessor;
		observersMap = new HashMap<Observer, DashboardFilter>();
	}

	/**
	 * This method registers the observer and filter with the subject
	 */
	public void registerObserver(Observer observer, DashboardFilter filter) {
		logger.printToLogFile(3, "DashboardSubject: registerObserver()");
		observersMap.put(observer, filter);
	}

	/**
	 * This method unregister the observer from the subject
	 */
	public void unregisterObserver(Observer observer) {
		logger.printToLogFile(3, "DashboardSubject: unregisterObserver()");
		observersMap.remove(observer);
	}

	/**
	 * This method starts the processing of subject
	 */
	public void startProcessing() {
		logger.printToLogFile(3, "DashboardSubject: start()");
		inputLine = fileProcessor.readLineFromFile();
		while (!"EOF".equals(inputLine)) {
			// TODO take care of TAB begin and TAB end
			if (inputLine != null) {
				notifyObservers();
			}
			inputLine = fileProcessor.readLineFromFile();
		}
	}

	/**
	 * This method notify all the observers if new string matches
	 */
	public void notifyObservers() {
		logger.printToLogFile(3, "DashboardSubject: notifyObservers()");
		Set<Observer> observers = observersMap.keySet();
		fileProcessor.writeToFile("---TAB(s) BEGIN---\n");
		String[] tabs = inputLine.split("\\*");
		// iterating through the set of observers
		for (int i = 0; i < tabs.length; ++i) {
			for (Observer observer : observers) {
				if (observersMap.get(observer).check(tabs[i]))
					observer.update(tabs[i]);
			}
		}
		fileProcessor.writeToFile("---TAB(s) END---\n");
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "DashboardSubject object";
	}
}
