package taskManager.subject;

import taskManager.observers.Observer;
import taskManager.filter.DashboardFilter;
/**
 * This interface is implemented by DashboardSubject
 */
public interface Subject{
	/**
	 * @param observer
	 * @param filter
	 * This method register the observer and filter to subject
	 */
	public void registerObserver(Observer observer, DashboardFilter filter);
	
	/**
	 * @param observer
	 * This method unregisters observer from subject
	 */
	public void unregisterObserver(Observer observer);
	
	/**
	 * This method notify all the observers if new string matches
	 */
	public void notifyObservers();
	
	/**
	 * This method starts processing of subject
	 */
	public void startProcessing();
}

