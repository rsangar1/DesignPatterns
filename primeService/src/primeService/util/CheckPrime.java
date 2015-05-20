package primeService.util;

/**
 * This class implements method to check number if it is prime
 * 
 */
public class CheckPrime implements CheckPrimeInterface{
	static final int THRESHOLD = 3;
	boolean prime = true;
	Debug debug = Debug.getInstance();
	

	/**
	 * This method checks if given input number is prime or not
	 * @return String
	 */
	public String isPrime(int number){
		debug.printToLogFile(1, "CheckPrime: isPrime()");
		debug.printToLogFile(4, "CheckPrime: isPrime()");
		if(number>THRESHOLD){
			if(number%2 == 0){
				return "Not prime";
			}
			if(number > 99999){
				return "No Idea!";
			}
			for(int i=2;i<=number/2;++i){
				if(number%i == 0){
					prime = false;
					break;
				}
			}
			if(prime)
				return "Yes it is prime";
			else
				return "Not prime";
		}else
			return "Not valid";
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "CheckPrime : toString()");
		debug.printToLogFile(4, "CheckPrime : toString()");
    	return "CheckPrime Object";
    }
}
