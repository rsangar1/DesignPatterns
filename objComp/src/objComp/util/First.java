package objComp.util;

import objComp.logger.MyLogger;

/**
 * @author Ramesh
 * This class represents simple bean with overridden methods of Object class
 */
public class First {
	private int IntValue;
	private String StringValue;
	MyLogger logger = MyLogger.getInstance();
	
	public First(){
		logger.printToLogFile(1, "First: constructor");
	}
	
	/**
	 * @param intIn
	 */
	public void setIntValue(int intIn){
		logger.printToLogFile(2, "First: setIntValue()");
		IntValue = intIn;
	}
	
	/**
	 * @param stringIn
	 */
	public void setStringValue(String stringIn){
		logger.printToLogFile(2, "First: setStringValue()");
		StringValue = stringIn;
	}
	
	/**
	 * @return int
	 */
	public int getIntValue(){
		logger.printToLogFile(2, "First: getIntValue()");
		return IntValue;
	}
	
	/**
	 * @return String
	 */
	public String getStringValue(){
		logger.printToLogFile(2, "First: getStringValue()");
		return StringValue;
	}
	
	/**
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj){ 
		logger.printToLogFile(2, "First: equals()");
		First anObject = (First)obj;
		if(this.hashCode() == obj.hashCode() &&
				this.IntValue == anObject.IntValue &&
				this.StringValue.equals(anObject.StringValue))
			return true;
		return false;
	}
	
	/**
	 * @return int
	 */
	@Override
	public int hashCode(){
		logger.printToLogFile(2, "First: hashCode()");
		int hash1 = new Integer(IntValue).hashCode();
		int hash2 = StringValue.hashCode();
		return 31*hash1+hash2;
	}
	
	/**
	 * String representation of this object
	 * @return String
	 */
	@Override
	public String toString(){
		logger.printToLogFile(2, "First: toString()");
		return "First class object\n";
	}
}
