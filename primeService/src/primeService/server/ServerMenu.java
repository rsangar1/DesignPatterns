package primeService.server;

import primeService.util.Debug;

/**
 * @author Ramesh
 * This class implements methods to display server menu options
 */
public class ServerMenu implements ServerMenuInterface{
	Debug debug = null;
	/** 
	 * This method print the server menu options
	 */
	public void printServerMenu(){
		debug = Debug.getInstance();
		debug.printToLogFile(1, "ServerMenu: printServerMenu()");
		debug.printToLogFile(4, "ServerMenu: printServerMenu()");
		System.out.println("===============Server Menu================\n");
		System.out.println("[1] Client name");
		System.out.println("[2] All Client queries");
		System.out.println("[3] Quit");		
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "ServerMenu : toString()");
		debug.printToLogFile(4, "ServerMenu : toString()");
    	return "ServerMenu Object";
    }
}
