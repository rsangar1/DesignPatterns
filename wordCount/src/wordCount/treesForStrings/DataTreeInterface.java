package wordCount.treesForStrings;

import java.util.Map;

import wordCount.visitors.Visitor;

public interface DataTreeInterface {
	/**
	 * This method accepts the visitor and the double dispatch comes
	 * in to picture.
	 */
	public void accept(Visitor visitor);
	
	/**
	 * This method returns the tree object
	 */
	public Map<Integer, NodeObject> getStringsTree();
}
