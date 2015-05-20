package bugModel.results;

import bugModel.util.Debug;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Results implements Display, FileLog, StoreMovements {
		private List<Movements> codesList;
	
	/**
	 * In this constructor, codesList has been instantiated
	 */
	public Results(){
		Debug.printToStdout(4, "constructor is called: Results class");
		codesList = new ArrayList<Movements>();
	}
		
	/* 
	 * This method stores the code in to list 
	 */
	public void storeCode(Movements code){
		Debug.printToStdout(3, "method is called: Results.storeCode");
		Debug.printToStdout(2, "Entry is added to the data structure");
		codesList.add(code);
	}
	
	/* 
	 * This method remove the code from the list
	 */
	public void removeCode()throws IndexOutOfBoundsException{
		Debug.printToStdout(3, "method is called: Results.removeCode");
		if(!codesList.isEmpty()){
			if(!(codesList.get(0).intCode == 0)){
				codesList.remove(codesList.size() - 1);
			}
		}
		else
			codesList.add(new Movements(0));
	}

	/**
	 * This method returns string format of contents of movements list
	 * @return String
	 */
	private String getListContents(){
		Debug.printToStdout(3, "method is called: Results.getListContents");
		StringBuffer sb = new StringBuffer();
		for(Movements ele: codesList){
			sb.append(ele.intCode);
		}
		return sb.toString();
	}
	
	/* 
	 * This method writes the list details to standard output
	 */
	public void writeListToStdout() {
		Debug.printToStdout(3, "method is called: Results.writeListToStdout");
		Debug.printToStdout(1, getListContents());
	}
	
	/* 
	 *This method writes the list details to file 
	 *@throws IOException
	 */
	public void writeListToFile(String fileName) throws IOException{
		Debug.printToStdout(3, "method is called: Results.writeListToFile");
		FileWriter newFile = new FileWriter(fileName);
		newFile.append(getListContents());
		newFile.close();
	}
	
	/* 
	 * This method returns the string representation of Results object
	 */
	public String toString() {
		Debug.printToStdout(3, "method is called: Results.toString");
    	String retValue = "\n Results Object \n";
    	return retValue;
    }
}


