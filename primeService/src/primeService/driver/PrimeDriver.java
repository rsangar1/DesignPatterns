package primeService.driver;

import java.util.Scanner;
import primeService.client.ClientDriver;
import primeService.server.ServerDriver;


/**
 * @author Ramesh
 * Date: 09-03-2015
 * This is the class with main method.
 * This class transfers the control to server or client
 */
public class PrimeDriver {

	/**
	 * This method transfers the control to ClientDriver or ServerDriver
	 * @param args
	 */
	public static void main(String[] args) {
		String clientOrServer = args[0];
		if(clientOrServer!=null){
			if(clientOrServer.equals("server")){
				(new ServerDriver(args)).createServerSocket();
			}else if(args[0].equals("client")){
				(new ClientDriver(args)).createClient();
			}else
				System.err.println("Please specify either client or server to start");
		}else{
			System.err.println("Invalid input entered.");
			System.exit(1);
		}
	}
}

