package primeService.client;

import primeService.util.Debug;

/**
 * @author Ramesh
 * This class contains the menu options
 *
 */
public class ClientMenu implements ClientMenuInterface{
	Debug debug = Debug.getInstance();
	
	/**
	 * This method prints the client menu options
	 */
	public void printClientMenu(){
		debug.printToLogFile(1, "ClientMenu: printClientMenu()");
		debug.printToLogFile(3, "ClientMenu: printClientMenu()");
		System.out.println("============Client Menu============\n");
		System.out.println("[1] Set Client name");
		System.out.println("[2] Enter number to query for prime");
		System.out.println("[3] What is the server response");
		System.out.println("[4] Quit");
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "method is called: ClientMenu.toString");
		debug.printToLogFile(3, "method is called: ClientMenu.toString");
    	return "ClientMenu Object";
    }
}
