package objComp.util;

import objComp.logger.MyLogger;

/**
 * @author Ramesh
 * This is simple bean class with overridden methods of Object class
 */
public class Second {
	private int IntValue;
	private double DoubleValue;
	MyLogger logger = MyLogger.getInstance();
	
	public Second(){
		logger.printToLogFile(1, "Second: constructor");
	}
	
	/**
	 * @param intIn
	 */
	public void setIntValue(int intIn){
		logger.printToLogFile(2, "Second: setIntValue()");
		IntValue = intIn;
	}
	
	/**
	 * @param doubleIn
	 */
	public void setDoubleValue(double doubleIn){
		logger.printToLogFile(2, "Second: setDoubleValue()");
		DoubleValue = doubleIn;
	}
	
	/**
	 * @return
	 */
	public int getIntValue(){
		logger.printToLogFile(2, "Second: getIntValue()");
		return IntValue;
	}
	
	/**
	 * @return
	 */
	public double getDoubleValue(){
		logger.printToLogFile(2, "Second: getDoubleValue()");
		return DoubleValue;
	}
	
	/**
	 * overriding equals method
	 */
	@Override
	public boolean equals(Object obj){
		logger.printToLogFile(2, "Second: equals()");
		Second anObject = (Second)obj;
		if(this.hashCode() == obj.hashCode()&&
				this.IntValue == anObject.IntValue &&
				this.DoubleValue == anObject.DoubleValue)
			return true;
		return false;
	}
	
	/**
	 * overriding hashCode method
	 * @return int
	 */
	@Override
	public int hashCode(){
		logger.printToLogFile(2, "Second: hashCode()");
		int hash1 = new Integer(IntValue).hashCode();
		int hash2 = new Double(DoubleValue).hashCode();
		return 31*hash1+hash2;
	}
	
	/**
	 * String representation of this object
	 * @return String
	 */
	@Override
	public String toString(){
		logger.printToLogFile(2, "Second: toString()");
		return "Second class object\n";
	}
}
