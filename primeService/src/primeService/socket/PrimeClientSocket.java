package primeService.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import primeService.util.Debug;

public class PrimeClientSocket implements Runnable, PrimeClientSocketInterface{
	Debug debug = Debug.getInstance();
	Socket clientSocket = null;
	DataOutputStream out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null;
	String host = null;
	int port = 0;
	PrimeClientWorkerInterface primeClientWorker = null;
	
	/**
	 * This constructor receives host and port details
	 * @param host
	 * @param port
	 */
	public PrimeClientSocket(String host, int port){
		debug.printToLogFile(2, "PrimeClientSocket: constructor");
		debug.printToLogFile(3, "PrimeClientSocket: constructor");
		this.host = host;
		this.port = port;
	}

	/** 
	 * A new socket is created for given host and port
	 * A new thread is started for given PrimeClientWorker
	 */
	public void run(){
		debug.printToLogFile(1, "PrimeClientSocket: run()");
		debug.printToLogFile(3, "PrimeClientSocket: run()");
		try{			
			clientSocket = new Socket(host, port);
			primeClientWorker = new PrimeClientWorker(clientSocket);
			(new Thread((Runnable)primeClientWorker)).start();
		}catch(IOException ioException){
			System.err.println("Exception while creating client socket"+ioException.getMessage());
			System.exit(1);
		}catch(Exception exception){
			System.err.println("Exception occured in PrimeServerSocket"+exception.getMessage());
			System.exit(1);
		}
	}
	
	/** 
	 * This method send client input to PrimeClientSocket
	 */
	public void sendClientInput(int inputValue) {
		debug.printToLogFile(1, "PrimeClientSocket: sendClientInput()");
		debug.printToLogFile(3, "PrimeClientSocket: run()");
		primeClientWorker.sendClientInput(inputValue);
	}

	/**
	 * This method call method from PrimeClientWorker to print server response
	 */
	public void getServerResponse() {
		debug.printToLogFile(1, "PrimeClientSocket: getServerResponse()");
		debug.printToLogFile(3, "PrimeClientSocket: getServerResponse()");
		primeClientWorker.printServerResponse();
	}

	/** 
	 * This method call method in PrimeClientWorker to set client name
	 */
	public void setClientName(String clientName) {
		debug.printToLogFile(1, "PrimeClientSocket: setClientName()");
		debug.printToLogFile(3, "PrimeClientSocket: setClientName()");
		primeClientWorker.setClientName(clientName);	
	}

	/**
	 * This method call method in PrimeClientWorker to close socket
	 */
	public void closeSocket() {
		debug.printToLogFile(1, "PrimeClientSocket: closeSocket()");
		debug.printToLogFile(3, "PrimeClientSocket: closeSocket()");
		primeClientWorker.closeClientSocket();
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "PrimeClientSocket : toString()");
		debug.printToLogFile(3, "PrimeClientSocket : toString()");
    	return "PrimeClientSocket Object";
    }
}
