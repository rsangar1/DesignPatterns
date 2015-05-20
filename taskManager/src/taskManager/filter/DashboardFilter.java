package taskManager.filter;

/**
 * This interface is implemented by all Filters
 * 
 */
public interface DashboardFilter {
	/**
	 * @param filterStr
	 * @return boolean This method check the filter string
	 */
	public boolean check(String filterStr);
}
