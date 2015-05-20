package taskManager.tabs;

import taskManager.logger.MyLogger;

/**
 * @author Ramesh This class acts as bean for Process tab
 */
public class Process {
	private String pid;
	private String command;
	private String user;
	private String cpu;
	private String memory;
	private MyLogger logger = MyLogger.getInstance();

	public Process() {
		logger.printToLogFile(2, "Process constructor");
	}

	// getters and setters for variables in class
	public String getPid() {
		logger.printToLogFile(3, "Process: getPid()");
		return pid;
	}

	public void setPid(String pid) {
		logger.printToLogFile(3, "Process: setPid()");
		this.pid = pid;
	}

	public String getCommand() {
		logger.printToLogFile(3, "Process: getCommand()");
		return command;
	}

	public void setCommand(String command) {
		logger.printToLogFile(3, "Process: setCommand()");
		this.command = command;
	}

	public String getUser() {
		logger.printToLogFile(3, "Process: getUser()");
		return user;
	}

	public void setUser(String user) {
		logger.printToLogFile(3, "Process: setUser()");
		this.user = user;
	}

	public String getCpu() {
		logger.printToLogFile(3, "Process: getCpu()");
		return cpu;
	}

	public void setCpu(String cpu) {
		logger.printToLogFile(3, "Process: setCpu()");
		this.cpu = cpu;
	}

	public String getMemory() {
		logger.printToLogFile(3, "Process: getMemory()");
		return memory;
	}

	public void setMemory(String memory) {
		logger.printToLogFile(3, "Process: setMemory()");
		this.memory = memory;
	}

	/**
	 * This method gives formatted string representation of this class
	 */
	public String toString() {
		logger.printToLogFile(3, "Process: toString()");
		return String.format("%5s %-16s%-8s  %s  %s", this.pid, this.command,
				this.user, this.cpu, this.memory + "\n");
	}

}
