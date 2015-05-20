package primeService.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import primeService.socket.PrimeServerSocket;
import primeService.socket.PrimeServerSocketInterface;
import primeService.util.Debug;

/**
 * @author Ramesh
 * This class acts as driver for Server
 *
 */
public class ServerDriver implements ServerDriverInterface{	
	int port = 0;
	PrimeServerSocketInterface primeServerSocket = null;
	BufferedReader stdIn = null;
	int serverChoice = 0;
	AllPrimeQueriesInterface allPrimeQueries = null;
	ServerMenuInterface serverMenu = null;
	Debug debug = Debug.getInstance();
	
	/**
	 * This is ServerDriver constructor
	 * @param args
	 */
	public ServerDriver(String[] args){
		debug.printToLogFile(2, "ServerDriver: constructor()");
		debug.printToLogFile(4, "ServerDriver: constructor()");
		validateServerArguments(args);
		debug.setDebugValue(1);
		debug.printToLogFile(2, "ServerDriver: constructor");
		this.port = (Integer.parseInt(args[1]));
		allPrimeQueries = new AllPrimeQueries();
	}
	
	
	/**
	 * This method validates the command line arguments entered to
	 * the server
	 * @param args
	 */
	private void validateServerArguments(String[] args) {
		debug.printToLogFile(1, "ServerDriver: validateServerArguments()");
		debug.printToLogFile(4, "ServerDriver: validateServerArguments()");
		int portNumber = 0;
		int debugValue = 0;
		if(args.length<4){
			System.err.println("Invalid number of arguments\n");
			System.exit(1);
		}
		try{
			portNumber = Integer.parseInt(args[1]);
			debugValue = Integer.parseInt(args[2]);
		}catch(NumberFormatException nfe){
			System.err.println("Invalid number entered\n");
			System.exit(1);
		}
		if(portNumber<1000 || portNumber>65535){
			System.err.println("Invalid port number entered\n");
			System.exit(1);
		}
		if(debugValue>4){
			System.err.println("Invalid debug value entered\n");
			System.exit(1);
		}
	}

	
	/**
	 * This method creates a server socket and prints the server menu options
	 * The input entered by user is read and sent to PrimeServerSocket for processing.
	 */
	public void createServerSocket(){
		debug.printToLogFile(1, "ServerDriver: createServerSocket()");
		debug.printToLogFile(4, "ServerDriver: createServerSocket()");
		try{
			primeServerSocket = new PrimeServerSocket(port, allPrimeQueries);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			new Thread((Runnable)primeServerSocket).start();
			serverMenu = new ServerMenu();
			while(true)
            {
				serverMenu.printServerMenu();
				String inputChoice = stdIn.readLine();
				if(inputChoice!=null){
					processServerInput(inputChoice);
				}
            }	
		}catch(IOException ioException){
			System.err.println("Error while reading from user "+ioException.getMessage());
		}catch(Exception exception){
			System.out.println("Server Driver is exiting "+ exception.getMessage());
		}finally{
			System.exit(1);
		}
	}

	/**
	 * This method calls the methods in PrimeServerSocket based on the user input
	 * @param inputChoice
	 */
	private void processServerInput(String inputChoice) {
		debug.printToLogFile(1, "ServerDriver : processServerInput()");
		debug.printToLogFile(4, "ServerDriver : processServerInput()");
		try{
			serverChoice = Integer.parseInt(inputChoice);
			switch(serverChoice){
			case 1:
				primeServerSocket.printClientDetails();
				break;
			case 2:
				primeServerSocket.printAllClientDetails();
				break;
			case 3:
				primeServerSocket.close();
				System.exit(1);
				break;
			default:
				System.err.println("Invalid choice choosen");
				break;
			}
		}catch(Exception exception){
			System.err.println("Error in server input "+ exception.getMessage());
		}
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "ServerDriver : toString()");
		debug.printToLogFile(4, "ServerDriver : toString()");
    	return "ServerDriver Object";
    }
}
