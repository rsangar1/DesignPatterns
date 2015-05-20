package primeService.socket;

/**
 * This interface contains to communicate with server
 */
public interface PrimeClientWorkerInterface {
	/**
	 * This method send the client name to server
	 */
	public void setClientName(String clientName);
	
	/**
	 * This method sends the client query to server
	 */
	public void sendClientInput(int keyValue);
	
	/**
	 * This method prints the response received from server
	 */
	public void printServerResponse();
	
	/**
	 * This method closes clinet connection and the input, output streams
	 */
	public void closeClientSocket();
}
