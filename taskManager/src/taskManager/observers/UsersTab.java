package taskManager.observers;

import java.util.ArrayList;
import java.util.List;

import taskManager.display.DisplayFile;
import taskManager.logger.MyLogger;
import taskManager.tabs.User;
import taskManager.util.FileProcessorInterface;

/**
 * Implementation of user tab
 */
public class UsersTab implements Observer, DisplayFile {
	private List<User> usersList = null;
	private FileProcessorInterface fileProcessor = null;
	private MyLogger logger = MyLogger.getInstance();

	/**
	 * @param fileProcessor
	 */
	public UsersTab(FileProcessorInterface fileProcessor) {
		logger.printToLogFile(2, "UsersTab constructor");
		this.fileProcessor = fileProcessor;
	}

	/**
	 * updates the observer with new input string
	 */
	public void update(String strIn) {
		logger.printToLogFile(3, "UsersTab: update()");
		processInputString(strIn);
	}

	/**
	 * @param strIn
	 * processes the input string as per Users tab
	 */
	private void processInputString(String strIn) {
		logger.printToLogFile(3, "UsersTab: processInputString()");
		usersList = new ArrayList<User>();
		User newUser = null;
		String[] users = strIn.substring("Users".length() + 1).split("-");
		String[] userDetails = null;
		for (String user : users) {
			userDetails = user.split(":");
			newUser = new User();
			newUser.setUsername(userDetails[0]);
			newUser.setStatus(userDetails[1]);
			usersList.add(newUser);
		}
		display();
	}

	/**
	 * This method writes the contents to the file
	 */
	public void display() {
		logger.printToLogFile(3, "UsersTab: display()");
		fileProcessor.writeToFile("---USERS---\n");
		for (User user : usersList) {
			fileProcessor.writeToFile(user.toString());
		}
		fileProcessor.writeToFile("\n");
	}
	
	/**
	 * This method gives string representation of this class object
	 */
	public String toString(){
		return "UsersTab object";
	}
}
