package primeService.client;

/**
 * @author Ramesh
 * This interface contains methods handle client
 */
public interface ClientDriverInterface {
	/**
	 * This method creates a new client socket by passing port and host
	 * details to PrimeClientSocket
	 */
	public void createClient();
}
