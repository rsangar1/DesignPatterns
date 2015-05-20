
package bugModel.driver;

import java.io.IOException;
import bugModel.results.FileLog;
import bugModel.results.Results;
import bugModel.results.Display;
import bugModel.results.StoreMovements;
import bugModel.bug.AllDirectionsBug;
import bugModel.bug.Bug;
import bugModel.util.Debug;

/**
 * @author Ramesh Sangaraju
 * Date : 17 - 02 - 2015
 * This is the Driver class with main method.
 */
public class Driver{
	public static void main(String args[]) {
		try{
			String fileName="";
			int level;
			//validating the number of arguments
			if(args.length < 2) {
				System.err.println("Invalid number of inputs specified");
				System.exit(1);
			}else{
				level = Integer.valueOf(args[0]);
				if(args[1]!=null || level>=0 && level<=4)
				{
					fileName = args[1];
					Debug.setDebugValue(level);
				}
				else{
					System.err.println("Invalid command line arguments specified");
					System.exit(1);
				}
			}
			Debug.printToStdout(3, "method is called: Driver.main");
			
			//'storeMovements' object is created
			StoreMovements storeMovements = new Results();
			//'storeMovements' object is passed as argument to Bug constructor
			AllDirectionsBug allDirectionsBug = new Bug(storeMovements);
			
			//calling the methods in Bug
			allDirectionsBug.moveLeft();
			allDirectionsBug.moveDown();
			allDirectionsBug.moveRight();
			allDirectionsBug.moveUp();
			//allDirectionsBug.moveUp();
			//allDirectionsBug.moveUp();
			//allDirectionsBug.moveUp();
			allDirectionsBug.undoPrev();
			allDirectionsBug.undoPrev();
			allDirectionsBug.undoPrev();
			allDirectionsBug.undoPrev();
			allDirectionsBug.undoPrev();
			allDirectionsBug.undoPrev();
			allDirectionsBug.moveLeft();
			allDirectionsBug.moveLeft();
			allDirectionsBug.moveRight();
			allDirectionsBug.moveUp();
					
			//Creating the instance of Display class.
			Display display = (Display)storeMovements;
			display.writeListToStdout();
			
			//creating the instance of Filelog.
			FileLog fileLog = (FileLog)storeMovements;
			fileLog.writeListToFile(fileName);
		}catch(IndexOutOfBoundsException indexOutOfBoundsException){
			System.err.println("Error occurred due to large index:"
					+indexOutOfBoundsException.getMessage());
		}catch(NumberFormatException numberFormatException){
			System.err.print("Program exited due to improper number format:"
					+numberFormatException.getMessage());
		}catch(IOException ioException){
			System.err.print("Program exited due to invalid input"
					+ioException.getMessage());
		}catch(Exception exception){
			System.err.print("Prgram ended abruptly. Please try again."
					+exception.getMessage());
		}finally{
			System.exit(1);
		}
	} 
} 
