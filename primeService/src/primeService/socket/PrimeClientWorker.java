package primeService.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import primeService.util.Debug;

/**
 * @author Ramesh
 * This class implements methods to communicate with server
 */
public class PrimeClientWorker implements Runnable, PrimeClientWorkerInterface{
	Socket clientSocket = null;
	DataOutputStream out = null;
	BufferedReader in = null;
	Debug debug = Debug.getInstance();
	
	/**
	 * @param socket
	 */
	public PrimeClientWorker(Socket socket){
		debug.printToLogFile(2, "PrimeClientWorker: constructor");
		debug.printToLogFile(3, "PrimeClientWorker: constructor");
		this.clientSocket = socket;
	}
	
	/** 
	 * This method creates objects for input and output streams
	 */
	public void run(){
		debug.printToLogFile(1, "PrimeClientWorker: run()");
		debug.printToLogFile(3, "PrimeClientWorker: run()");
		try{
			out = new DataOutputStream(clientSocket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		}catch(IOException ioException){
			System.out.println("IO exception in client worker");
		}
	}

	/**
	 * This method send the client name to server
	 */
	public void setClientName(String clientName) {
		debug.printToLogFile(1, "PrimeClientWorker: setClientName()");
		debug.printToLogFile(3, "PrimeClientWorker: setClientName()");
		try{
			out.writeBytes(1+"\n");
			out.writeBytes(clientName+"\n");
		}catch (IOException e) {
			System.err.println("error while entering client name "+ e.getMessage());
			System.exit(1);
		}
		
	}
	
	/**
	 * This method sends the client query to server
	 */
	public void sendClientInput(int keyValue) {
		debug.printToLogFile(1, "PrimeClientWorker: sendClientInput()");
		debug.printToLogFile(3, "PrimeClientWorker: sendClientInput()");
		try {
			out.writeBytes(2+"\n");
			out.writeBytes(keyValue+"\n");
		} catch (IOException e) {
			System.err.println("error while entering client query "+e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * This method prints the response received from server
	 */
	public void printServerResponse() {
		debug.printToLogFile(1, "PrimeClientWorker: getServerResponse()");
		debug.printToLogFile(3, "PrimeClientWorker: getServerResponse()");
		try {
			out.writeBytes(3+"\n");
			System.out.println(in.readLine());
		} catch (IOException e) {
			System.err.println("Error while printing server response "+e.getMessage());
			System.exit(1);
		}
	}

	/**
	 * This method closes clinet connection and the input, output streams
	 */
	public void closeClientSocket() {
		debug.printToLogFile(1, "PrimeClientWorker: closeClientSocket()");
		debug.printToLogFile(3, "PrimeClientWorker: closeClientSocket()");
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			System.err.println("Error while closing client resources "+e.getMessage());
		} finally{
			System.exit(1);
		}
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "PrimeClientWorker : toString()");
		debug.printToLogFile(3, "PrimeClientWorker : toString()");
    	return "PrimeClientWorker Object";
    }
}
