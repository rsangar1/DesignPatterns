package wordCount.treesForStrings;

import java.util.Map;
import java.util.TreeMap;

import wordCount.util.MyLogger;
import wordCount.visitors.Visitor;
import wordCount.treesForStrings.NodeObject;

/**
 * This acts as an element and it contains tree object
 * that we pass to different visitors
 */
public class DataTree implements DataTreeInterface{
	private Map<Integer, NodeObject> stringsTree = null;
	MyLogger logger = MyLogger.getInstance();
	
	public DataTree(){
		logger.printToLogFile(1, "DataTree: constructor");
		stringsTree = new TreeMap<Integer, NodeObject>();
	}

	/**
	 * This method returns the tree object
	 */
	public Map<Integer, NodeObject> getStringsTree() {
		logger.printToLogFile(2, "DataTree: constructor");
		return stringsTree;
	}
	
	/**
	 * @param visitor
	 * Double dispatch comes into picture in this method
	 */
	public void accept(Visitor visitor){
		logger.printToLogFile(2, "DataTree: accept()");
		visitor.visit(this);
	}
	
	/**
	 * String representation of DataTree class object
	 */
	public String toString(){
		logger.printToLogFile(2, "DataTree: toString()");
		return "\n DataTree object\n";
	}
}


