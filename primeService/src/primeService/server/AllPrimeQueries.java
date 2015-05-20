package primeService.server;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import primeService.util.CheckPrime;
import primeService.util.Debug;

/**
 * This class implements methods to insert and retrieve values from table
 */
public class AllPrimeQueries implements AllPrimeQueriesInterface{
	Debug debug = Debug.getInstance();
	public Map<String, List<Integer>> clientPrimeTable = new ConcurrentHashMap<String, List<Integer>>();
	String clientName = null;
	int clientInput = 0;
	List<Integer> queriesList = null;
	
	/**
	 * This method insert the client details into the table
	 */
	public void insertIntoClientPrimeTable(String clientName, int clientInput) {
		debug.printToLogFile(1, "AllPrimeQueries: insertIntoClientPrimeTable()");
		this.clientName = clientName;
		this.clientInput = clientInput;
		if(clientPrimeTable.containsKey(clientName)){
			clientPrimeTable.get(clientName).add(clientInput);
		}else{
			queriesList = new LinkedList<Integer>();
			queriesList.add(clientInput);
			clientPrimeTable.put(clientName, queriesList);
		}
	}

	/**
	 * This method returns response from the table based on client input
	 */
	public String getResponse(int clientInput) {
		debug.printToLogFile(1, "AllPrimeQueries: getResponse()");
		return new CheckPrime().isPrime(clientInput);		
	}

	/**
	 * This method prints all the client details stored in table
	 */
	public void printAllClients() {
		debug.printToLogFile(1, "AllPrimeQueries: printAllClients()");
		Set<String> clientSet = clientPrimeTable.keySet();
		if(!clientSet.isEmpty()){
			Iterator<String> iterator = clientSet.iterator();
			while(iterator.hasNext()){
				String clientName = iterator.next();
				System.out.println(clientName+" "+printClientQueries(clientName));
			}
		}else{
			System.err.println("No client queries to show");
		}
	}

	/**
	 * This method iterates through the queries for given client name
	 * @param clientName
	 * @return
	 */
	private String printClientQueries(String clientName) {
		debug.printToLogFile(1, "AllPrimeQueries: printClientQueries()");
		StringBuffer queriesBuffer = new StringBuffer();
		if(clientName!=null){
			queriesList = clientPrimeTable.get(clientName);
			Iterator<Integer> iterator = queriesList.iterator();
			while(iterator.hasNext()){
				queriesBuffer.append(iterator.next()+" ");
			}
		}else
			queriesBuffer.append("No client details found\n"); 
		return new String(queriesBuffer);
	}

	/**
	 * This method display the details of current client
	 *//*
	public void displayCurrentClientDetails() {
		debug.printToLogFile(1, "AllPrimeQueries: displayCurrentClientDetails()");
		if(clientName!=null)
			System.out.println(clientName+" "+printClientQueries(clientName));	
		else
			System.err.println("No client details available");
	}
*/
	/** 
	 * This method gives the string representation of this class object object
	 * @return String
	 */
	public String toString() {
		debug.printToLogFile(1, "AllPrimeQueries : toString()");
    	return "AllPrimeQueries Object";
    }
}
