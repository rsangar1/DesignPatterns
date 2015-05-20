package taskManager.tabs;

import taskManager.logger.MyLogger;

/**
 * @author Ramesh This class acts as a bean for Performance object
 */
public class Performance {
	private String totalMemory;
	private String usedMemory;
	private String freeMemory;
	private String cachedMemory;
	private String cpuIdle;
	private String userLevel;
	private String systemLevel;
	private MyLogger logger = MyLogger.getInstance();

	public Performance() {
		logger.printToLogFile(2, "Performane constructor");
	}

	// Getters and setters for all the variables
	public String getTotalMemory() {
		logger.printToLogFile(3, "Performance: getTotalMemory");
		return totalMemory;
	}

	public void setTotalMemory(String totalMemory) {
		logger.printToLogFile(3, "Performance: setTotalMemory");
		this.totalMemory = totalMemory;
	}

	public String getUsedMemory() {
		logger.printToLogFile(3, "Performance: getUsedMemory");
		return usedMemory;
	}

	public void setUsedMemory(String usedMemory) {
		logger.printToLogFile(3, "Performance: setUsedMemory");
		this.usedMemory = usedMemory;
	}

	public String getFreeMemory() {
		logger.printToLogFile(3, "Performance: getFreeMemory");
		return freeMemory;
	}

	public void setFreeMemory(String freeMemory) {
		logger.printToLogFile(3, "Performance: setFreeMemory");
		this.freeMemory = freeMemory;
	}

	public String getCachedMemory() {
		logger.printToLogFile(3, "Performance: getCachedMemory");
		return cachedMemory;
	}

	public void setCachedMemory(String cachedMemory) {
		logger.printToLogFile(3, "Performance: setCachedMemory");
		this.cachedMemory = cachedMemory;
	}

	public String getCpuIdle() {
		logger.printToLogFile(3, "Performance: getCpuIdle");
		return cpuIdle;
	}

	public void setCpuIdle(String cpuIdle) {
		logger.printToLogFile(3, "Performance: setCpuIdle");
		this.cpuIdle = cpuIdle;
	}

	public String getUserLevel() {
		logger.printToLogFile(3, "Performance: getUserLevel");
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		logger.printToLogFile(3, "Performance: setUserLevel");
		this.userLevel = userLevel;
	}

	public String getSystemLevel() {
		logger.printToLogFile(3, "Performance: getSystemLevel");
		return systemLevel;
	}

	public void setSystemLevel(String systemLevel) {
		logger.printToLogFile(3, "Performance: setSystemLevel");
		this.systemLevel = systemLevel;
	}

	/**
	 * This represents the string representation of Performance object
	 */
	public String toString() {
		logger.printToLogFile(3, "Performance: toString");
		return "Memory Total: " + this.totalMemory + "  Memory Used: "
				+ this.usedMemory + "  Memory  Free: " + this.freeMemory
				+ "  Memory  Cached: " + this.cachedMemory + "\nCPU Idle: "
				+ this.cpuIdle + "  CPU User Level: " + this.userLevel
				+ "  CPU System Level: " + this.systemLevel + "\n";
	}
}
