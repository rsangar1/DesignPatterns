package primeService.socket;

public interface PrimeServerSocketInterface {
	/**
	 * This method call server worker method to print the client details
	 */
	public void printClientDetails();
	
	/**
	 * This method call server worker method to print all the client details
	 */
	public void printAllClientDetails();
	
	/**
	 * This method close the server socket and exit from system
	 */
	public void close();
}
