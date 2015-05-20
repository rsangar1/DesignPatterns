package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;

/**
 * This class is filter of Performance tab
 * 
 */
public class PerformanceTabFilterImpl implements DashboardFilter {
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * This method checks the string for "Performance"
	 */
	public boolean check(String filterStr) {
		logger.printToLogFile(3, "PerformanceTabFilterImpl: check()");
		if (filterStr.startsWith("Performance"))
			return true;
		return false;
	}

	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "PerformanceTabFilterImpl object";
	}
}
