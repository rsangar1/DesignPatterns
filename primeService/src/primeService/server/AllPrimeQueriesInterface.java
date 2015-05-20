package primeService.server;

/**
 * This interface contains methods to process client queries
 */
public interface AllPrimeQueriesInterface {
	/**
	 * This method insert the client details into the table
	 */
	public void insertIntoClientPrimeTable(String clientName, int clientInput);
	
	/**
	 * This method returns response from the table based on client input
	 */
	public String getResponse(int clientInput);
	
	/**
	 * This method prints all the client details stored in table
	 */
	public void printAllClients();
	
/*	*//**
	 * This method display the details of current client
	 *//*
	public void displayCurrentClientDetails();*/
}
