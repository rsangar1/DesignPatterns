package primeService.server;

/**
 * @author Ramesh
 * This interface contains methods to create server socket
 */
public interface ServerDriverInterface {
	/**
	 * This method creates a server socket and prints the server menu options
	 * The input entered by user is read and sent to PrimeServerSocket for processing.
	 */
	public void createServerSocket();
	
}
