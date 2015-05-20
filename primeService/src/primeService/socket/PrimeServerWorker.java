package primeService.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import primeService.server.AllPrimeQueriesInterface;
import primeService.util.Debug;

/**
 * @author Ramesh
 * This class implements methods to deal with client inputs, process inputs and
 * respon to client
 */
public class PrimeServerWorker implements Runnable, PrimeServerWorkerInterface{
	Debug debug = null;
	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	DataOutputStream out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null;
	int clientInput = 0;
	String clientName = null;
	int clientChoice = 0;
	AllPrimeQueriesInterface allPrimeQueries = null;
	
	/**
	 * @param socket
	 * @param allPrimeQueries
	 */
	public PrimeServerWorker(Socket socket, AllPrimeQueriesInterface allPrimeQueries){
		debug = Debug.getInstance();
		debug.printToLogFile(2, "PrimeServerWorker: constructor");
		debug.printToLogFile(4, "PrimeServerWorker: constructor");
		this.clientSocket = socket;
		this.allPrimeQueries = allPrimeQueries;
	}
	
	/**
	 * This metho creates input and output streams and deal with respective client input
	 */
	public void run(){
		debug.printToLogFile(1, "PrimeServerWorker: run()");
		debug.printToLogFile(4, "PrimeServerWorker: run()");
		try{
			if(clientSocket!=null){
				out = new DataOutputStream(clientSocket.getOutputStream());
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				stdIn = new BufferedReader(new InputStreamReader(System.in));
				while(true){
					String input = in.readLine();
					if(input!=null){
						try{
							clientChoice = Integer.parseInt(input);
							switch(clientChoice){
							case 1:
								clientName = in.readLine();
								break;
							case 2:
								clientInput = Integer.parseInt(in.readLine());
								allPrimeQueries.insertIntoClientPrimeTable(clientName, clientInput);
								break;
							case 3:
								String response = allPrimeQueries.getResponse(clientInput);
								out.writeBytes(response+"\n");
								break;
							default:
								System.out.println("Invalid client option");
								break;
							}
						}catch(NumberFormatException nfe){
							System.err.println("Invalid input format"+ nfe.getMessage());
						}catch(Exception exception){
							System.err.println("Invalid input format"+ exception.getMessage());
						}
					}
				}
			}
		}catch(IOException ioException){
			System.err.println("Error while creating I/O streams "+ioException.getMessage());
		}catch(Exception exception){
			System.err.println("Error in PrimeServerWorker but y"+exception.getMessage());
		}finally{
			try{
				stdIn.close();
				out.close();
				in.close();
			}catch(IOException ioException){
				System.err.println("Exception while closing IO streams"+ioException.getMessage());
			}
		}
	}

	/**
	 * This method print the current client details
	 */
	public void printClientDetails() {
		debug.printToLogFile(1, "PrimeServerWorker: printClientDetails()");
		debug.printToLogFile(4, "PrimeServerWorker: printClientDetails()");
		System.out.println(clientName+" "+clientInput);
	}

	/**
	 * This method print all the client details available in the database
	 */
	public void printAllClientDetails() {
		debug.printToLogFile(1, "PrimeServerWorker: printAllClientDetails()");
		debug.printToLogFile(4, "PrimeServerWorker: printAllClientDetails()");
		allPrimeQueries.printAllClients();	
	}
	
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "PrimeServerWorker : toString()");
		debug.printToLogFile(4, "PrimeServerWorker : toString()");
    	return "PrimeServerWorker Object";
    }
	
}
