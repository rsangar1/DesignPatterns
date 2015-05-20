package taskManager.observers;

import taskManager.filter.DashboardFilter;
import taskManager.logger.MyLogger;

/**
 * Implementation of Users tab filter
 * 
 */
public class UsersTabFilterImpl implements DashboardFilter {
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * This method checks for the "Users" string
	 */
	public boolean check(String filterStr) {
		logger.printToLogFile(3, "UsersTabFilterImpl: check()");
		if (filterStr.startsWith("Users"))
			return true;
		return false;
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "UsersTabFilterImpl object";
	}
}
