package primeService.socket;

public interface PrimeServerWorkerInterface {
	/**
	 * This method print the current client details
	 */
	public void printClientDetails();
	
	/**
	 * This method print all the client details available in the database
	 */
	public void printAllClientDetails();
}
