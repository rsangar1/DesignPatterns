package bugModel.bug;

import bugModel.results.Movements;
import bugModel.results.StoreMovements;
import bugModel.util.Debug;

/**
 * @author Ramesh Sangaraju
 * This class implements the methods in AllDirectionBug interface
 */
public class Bug implements AllDirectionsBug {
	StoreMovements storeMovements;
	
	/**
	 * This constructor initializes StoreMovements object
	 * @param res
	 */
	public Bug(StoreMovements res){
		Debug.printToStdout(4, "constructor is called: Bug class");
		storeMovements = res;
	}
	/* 
	 * This method is called to move the bug in right direction
	 */
	public void moveRight(){
		Debug.printToStdout(3, "method is called: Bug.moveRight");
		storeMovements.storeCode(new Movements(1));
	}
	/* 
	 * This method is called to move the bug in left direction
	 */
	public void moveLeft(){
		Debug.printToStdout(3, "method is called: Bug.moveLeft");
		storeMovements.storeCode(new Movements(2));
	}
	/* 
	 * This method is called to move the bug upwards
	 */
	public void moveUp(){
		Debug.printToStdout(3, "method is called: Bug.moveUp");
		storeMovements.storeCode(new Movements(3));
	}
	/* 
	 * This method is called to move the bug downwads
	 */
	public void moveDown(){
		Debug.printToStdout(3, "method is called: Bug.moveDown");
		storeMovements.storeCode(new Movements(4));
	}
	/* 
	 * This method is called to undo the previous movement of bug
	 */
	public void undoPrev(){
		Debug.printToStdout(3, "method is called: Bug.movePrev");
		storeMovements.removeCode();
	}
	
	/* 
	 * This method gives the string representation of Bug object
	 * @return String
	 */
	public String toString() {
		Debug.printToStdout(3, "method is called: Bug.toString");
    	String retValue = "\n Bug Object \n";
    	return retValue;
    }

}