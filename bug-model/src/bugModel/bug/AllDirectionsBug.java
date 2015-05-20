package bugModel.bug;

/**
 * This interface contains the methods of all directions bug
 * @author Ramesh
 */
public interface AllDirectionsBug {
    /**
	 * This method is called to move the bug in right direction
	 */
	public void moveRight();
	/**
	 * This method is called to move the bug in left direction
	 */
	public void moveLeft();
	/**
	 * This method is called to move the bug upwards
	 */
	public void moveUp();
	/**
	 * This method is called to move the bug downwards
	 */
	public void moveDown();
	/**
	 * This method is called to undo the previous movement of bug
	 */
	public void undoPrev();
}