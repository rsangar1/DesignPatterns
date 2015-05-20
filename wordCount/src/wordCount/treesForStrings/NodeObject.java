package wordCount.treesForStrings;

import wordCount.util.MyLogger;

/**
 * This acts as a node object to store the string and corresponding
 * frequency of the string
 */
public class NodeObject{
	private String string;
	private int frequency;
	private MyLogger logger = MyLogger.getInstance();
	
	/**
	 * @param string
	 */
	public NodeObject(String string){
		logger.printToLogFile(1, "NodeObject: constructor");
		this.string = string;
		this.frequency = 1;
	}

	//getters and setters for the data members
	/**
	 * @return frequency
	 */
	public int getFrequency() {
		logger.printToLogFile(2, "NodeObject: getFrequency()");
		return frequency;
	}

	/**
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		logger.printToLogFile(2, "NodeObject: setFrequency()");
		this.frequency = frequency;
	}

	/**
	 * @return string
	 */
	public String getString() {
		logger.printToLogFile(2, "NodeObject: getString()");
		return string;
	}

	/**
	 * @param string
	 */
	public void setString(String string) {
		logger.printToLogFile(2, "NodeObject: setString()");
		this.string = string;
	}
	
	/**
	 * This method gives string representation of NodeObject class
	 */
	@Override
	public String toString(){
		logger.printToLogFile(2, "NodeObject: toString()");
		return "\nNodeObject class object\n";
	}
}
