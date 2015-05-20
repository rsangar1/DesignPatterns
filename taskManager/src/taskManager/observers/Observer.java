package taskManager.observers;

/**
 * This interface is implemented by all observers
 * 
 */
public interface Observer {
	/**
	 * @param strIn
	 * This method updates the observers with input string
	 */
	public void update(String strIn);
}
