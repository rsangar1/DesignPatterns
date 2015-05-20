package wordCount.visitors;

import java.util.Map;
import java.util.Set;

import wordCount.treesForStrings.DataTreeInterface;
import wordCount.treesForStrings.NodeObject;
import wordCount.util.FileProcessorInterface;
import wordCount.util.MyLogger;

/**
 * This acts as a visitor that calculate number of words and characters
 * in the tree that was already populated.
 */
public class WordCountVisitor implements Visitor{
	private FileProcessorInterface fileProcessor = null;
	private MyLogger logger = MyLogger.getInstance();
	
	public WordCountVisitor(FileProcessorInterface fileProcessor){
		logger.printToLogFile(1, "WordCountVisitor:constructor");
		this.fileProcessor = fileProcessor;
	}
	
	/**
	 * @param DataTreeInterface
	 */
	@Override
	public void visit(DataTreeInterface dataTree) {
		logger.printToLogFile(2, "WordCountVisitor:visit()");
		Map<Integer, NodeObject> stringsTree = dataTree.getStringsTree();
		int uniqueWordCount = 0;
		int wordCount = 0;
		int charCount = 0;
		Set<Integer> keys = stringsTree.keySet();
		for(int key: keys){
			NodeObject node = stringsTree.get(key);
			int frequency = node.getFrequency();
			uniqueWordCount++;
			wordCount += frequency;
			charCount += node.getString().length()*frequency;	
		}
		fileProcessor.writeToFile("UniqueWords:"+uniqueWordCount+"\n"+
							"Words:"+wordCount+"\n"+
							"Characters:"+charCount+"\n\n");
		fileProcessor.closeOutputFile();
	}
	
	/**
	 * String representation of WordCountVisitor object
	 */
	@Override
	public String toString(){
		logger.printToLogFile(2, "WordCountVisitor: toString()");
		return "\nWordCountVisitor object\n";
	}

}
