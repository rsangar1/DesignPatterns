package primeService.socket;

public interface PrimeClientSocketInterface {
	/** 
	 * This method send client input to PrimeClientSocket
	 */
	public void sendClientInput(int inputValue);
	
	/**
	 * This method call method from PrimeClientWorker to print server response
	 */
	public void getServerResponse();
	
	/** 
	 * This method call method in PrimeClientWorker to set client name
	 */
	public void setClientName(String clientName);
	
	/**
	 * This method call method in PrimeClientWorker to close socket
	 */
	public void closeSocket();
}
