package primeService.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import primeService.socket.PrimeClientSocket;
import primeService.socket.PrimeClientSocketInterface;
import primeService.util.Debug;

/**
 * @author Ramesh
 * This method acts as driver for Client
 */
public class ClientDriver implements ClientDriverInterface{
	Debug debug = Debug.getInstance();
	Socket socket = null;
	BufferedReader stdIn = null;
	DataOutputStream out = null;
	int clientChoice = 0;
	StringBuffer keyValue = null;
	PrimeClientSocketInterface primeClientSocket = null;
	ClientMenuInterface clientMenu = null;
	String clientName = null;
	int inputNumber = 0;
	String host = null;
	int port = 0;
	
	/**
	 * Constructor for ClientDriver
	 * @param args
	 */
	public ClientDriver(String[] args){
		debug.printToLogFile(2, "ClientDriver: constructor()");
		validateArguments(args);
		this.host = args[1];
		this.port = Integer.parseInt(args[2]);
		debug.setDebugValue(Integer.parseInt(args[3]));
		debug.printToLogFile(2, "ClientDriver: constructor");
		createClient();
	}
	
	
	/**
	 * This method validates the command line arguments entered to the client
	 * @param args
	 */
	private void validateArguments(String[] args) {
		debug.printToLogFile(1, "ClientDriver: validateArguments()");
		debug.printToLogFile(3, "ClientDriver: validateArguments()");
		int portNumber = 0;
		int debugValue = 0;
		if(args.length<4){
			System.err.println("Invalid number of arguments");
			System.exit(1);
		}
		try{
			portNumber = Integer.parseInt(args[2]);
			debugValue = Integer.parseInt(args[3]);
		}catch(NumberFormatException nfe){
			System.err.println("Invalid number entered");
			System.exit(1);
		}
		if(args[1]!=null){
			if(portNumber<1000 && portNumber>65535){
				System.err.println("Invalid port number entered");
				System.exit(1);
			}else if(debugValue>3){
				System.err.println("Invalid debug value entered");
				System.exit(1);
			}
		}else{
			System.err.println("No host name specified");
			System.exit(1);
		}
		
	}

	
	/**
	 * This method creates a new client socket by passing port and host
	 * details to PrimeClientSocket
	 */
	public void createClient(){
		debug.printToLogFile(1, "ClientDriver: createClient()");
		debug.printToLogFile(3, "ClientDriver: createClient()");
		try{
			debug.printToLogFile(1, "ClientDriver: createClient()");
			primeClientSocket = new PrimeClientSocket(host, port);
			new Thread((Runnable) primeClientSocket).start();
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			clientMenu = new ClientMenu();
			while(true){
				clientMenu.printClientMenu();
				String input = stdIn.readLine();
				if(input!=null){
					processClientInput(input);
				}
			}
		}catch(IOException ioException){
			System.err.println("Exception occurred while reading client input"+ioException.getMessage());
		}catch(Exception exception){
			System.err.print("Exiting client driver due to exception "+ exception.getMessage());
		}
		finally{
			System.exit(1);
		}
	}

	/**
	 * This method validates the command line arguments entered to
	 * the server
	 * @param input
	 */
	private void processClientInput(String input) {
		debug.printToLogFile(1, "ClientDriver: processClientInput()");
		debug.printToLogFile(3, "ClientDriver: processClientInput()");
		try{
			clientChoice = Integer.parseInt(input);
			switch(clientChoice){
			case 1:
				clientName = stdIn.readLine();
				primeClientSocket.setClientName(clientName);
				break;
			case 2:
				inputNumber = Integer.parseInt(stdIn.readLine());
				primeClientSocket.sendClientInput(inputNumber);
				break;
			case 3:
				primeClientSocket.getServerResponse();
				break;
			case 4:
				primeClientSocket.closeSocket();
			default:
				System.err.println("Invalid option entered");
				break;
			}
		}catch(IOException ioException){
			System.out.println("Exception reading client input"+ioException.getMessage());
		}catch(Exception exception){
			System.out.println("Invalid client input "+exception.getMessage());
		}
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "ClientDriver: toString()");
		debug.printToLogFile(3, "ClientDriver: toString()");
    	return "ClientDriver Object";
    }
}
