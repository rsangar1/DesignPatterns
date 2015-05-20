package primeService.socket;

import java.io.IOException;
import java.net.ServerSocket;
import primeService.server.AllPrimeQueriesInterface;
import primeService.util.Debug;

/**
 * @author Ramesh
 * This class implements method to create and communicate with socket
 */
public class PrimeServerSocket implements Runnable, PrimeServerSocketInterface{
	Debug debug = null;
	ServerSocket serverSocket = null;
	int port = 0;
	AllPrimeQueriesInterface allPrimeQueries = null;
	PrimeServerWorkerInterface serverWorker = null;
	
	/**
	 * @param port
	 * @param allPrimeQueries
	 */
	public PrimeServerSocket(int port, AllPrimeQueriesInterface allPrimeQueries){
		debug = Debug.getInstance();
		debug.printToLogFile(2, "PrimeServerSocket: constructor");
		debug.printToLogFile(4, "PrimeServerSocket: constructor");
		this.port = port;
		this.allPrimeQueries = allPrimeQueries;
	}
	
	/**
	 * This method creates new thread for each client connection
	 */
	public void run(){
		debug.printToLogFile(1, "PrimeServerSocket: run()");
		debug.printToLogFile(4, "PrimeServerSocket: run()");
		try{
			this.serverSocket = new ServerSocket(port);
			while(true){
				if(serverSocket!=null){
					serverWorker = new PrimeServerWorker(serverSocket.accept(), allPrimeQueries);
					new Thread((Runnable)serverWorker).start();
				}
			}
		}catch(IOException ioException){
			System.err.println("Problem accepting client connection "+ioException.getMessage());
		}catch(Exception exception){
			System.err.println("Exception in PrimeServerSocket"+exception.getMessage());
		}
	}
	
	/**
	 * This method call server worker method to print the client details
	 */
	public void printClientDetails() {
		debug.printToLogFile(1, "PrimeServerSocket: printClientDetails()");
		debug.printToLogFile(4, "PrimeServerSocket: printClientDetails()");
		serverWorker.printClientDetails();
	}

	/**
	 * This method call server worker method to print all the client details
	 */
	public void printAllClientDetails() {
		debug.printToLogFile(1, "PrimeServerSocket: printAllClientDetails()");
		debug.printToLogFile(4, "PrimeServerSocket: printAllClientDetails()");
		serverWorker.printAllClientDetails();		
	}
	
	/**
	 * This method close the server socket and exit from system
	 */
	public void close() {
		debug.printToLogFile(1, "PrimeServerSocket: close()");
		debug.printToLogFile(4, "PrimeServerSocket: close()");
		try {
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Exception while closing the server socket"+e.getMessage());
			e.printStackTrace();
		}finally{
			System.exit(1);
		}
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "PrimeServerSocket : toString()");
		debug.printToLogFile(4, "PrimeServerSocket : toString()");
    	return "PrimeServerSocket Object";
    }
}
