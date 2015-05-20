package bugModel.results;

/**
 * @author Ramesh
 * This interface has methods to store and remove movement codes of bug
 *
 */
public interface StoreMovements {
	/**
	 * This method stores the code in to list
	 * @param code
	 * @throws IndexOutOfBoundsException
	 */
	public void storeCode(Movements code) throws IndexOutOfBoundsException;
	/**
	 * This method remove the code from the list
	 */
	public void removeCode();
}
