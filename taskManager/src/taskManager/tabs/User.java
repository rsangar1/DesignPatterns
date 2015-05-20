package taskManager.tabs;

import taskManager.logger.MyLogger;

/**
 * This class acts as bean for User tab
 */
public class User {
	private String username;
	private String status;
	private MyLogger logger = MyLogger.getInstance();

	public User() {
		logger.printToLogFile(2, "User constructor");
	}

	// getters and setters for variables
	public void setUsername(String username) {
		logger.printToLogFile(3, "User: setUsername()");
		this.username = username;
	}

	public String getUsername() {
		logger.printToLogFile(3, "User: getUsername()");
		return this.username;
	}

	public void setStatus(String status) {
		logger.printToLogFile(3, "User: setStatus()");
		this.status = status;
	}

	public String getStatus() {
		logger.printToLogFile(3, "User: getStatus()");
		return this.status;
	}

	/**
	 * This method gives the formatted string representation of User object
	 */
	public String toString() {
		logger.printToLogFile(3, "User: toString()");
		return "User: " + this.username + "  " + "Status: " + this.status
				+ "\n";
	}
}
