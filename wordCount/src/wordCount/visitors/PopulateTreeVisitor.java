package wordCount.visitors;

import java.util.Map;

import wordCount.treesForStrings.DataTreeInterface;
import wordCount.treesForStrings.NodeObject;
import wordCount.util.FileProcessorInterface;
import wordCount.util.MyLogger;

/**
 * This class acts as visitor to populate the tree with strings 
 * read from input file
 */
public class PopulateTreeVisitor implements Visitor{
	private FileProcessorInterface fileProcessor = null;
	private MyLogger logger = MyLogger.getInstance();
	//private int cores = Runtime.getRuntime().availableProcessors();
	public PopulateTreeVisitor(FileProcessorInterface fileProcessor){
		logger.printToLogFile(1, "PopulateTreeVisitor: constructor");
		this.fileProcessor = fileProcessor;
	}
	
	/**
	 * This method populate the tree with the strings from input file
	 */
	@Override
	public void visit(DataTreeInterface dataTree) {
		logger.printToLogFile(2, "PopulateTreeVisitor: visit()");
		Map<Integer, NodeObject> stringsTree = dataTree.getStringsTree(); 
		String string = fileProcessor.readLineFromFile();
		while(string != null){
			if(!(string = string.trim()).equals("")){
				int stringHashCode = string.hashCode();
				if(stringsTree.containsKey(stringHashCode)){
					NodeObject node = stringsTree.get(stringHashCode);
					node.setFrequency(node.getFrequency()+1);
				}else{
					stringsTree.put(stringHashCode, new NodeObject(string));
				}
			}
			string = fileProcessor.readLineFromFile();
		}
		fileProcessor.closeInputFile();
	}
	
	/**
	 * String representation of PopulateTreeVisitor object
	 */
	@Override
	public String toString(){
		logger.printToLogFile(2, "PopulateTreeVisitor: toString()");
		return "\nPopulateTreeVisitor object\n";
	}

}
