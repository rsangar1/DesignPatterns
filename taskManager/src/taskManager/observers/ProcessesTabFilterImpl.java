package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;

/**
 * Process tab filter implementation
 * 
 */
public class ProcessesTabFilterImpl implements DashboardFilter {
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * This method checks the string for "Processes" string
	 */
	public boolean check(String filterStr) {
		logger.printToLogFile(3, "ProcessesTabFilterImpl: check()");
		if (filterStr.startsWith("Processes"))
			return true;
		return false;
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "ProcessesTabFilterImpl object";
	}

}
