package wordCount.visitors;

import wordCount.treesForStrings.DataTreeInterface;

public interface Visitor {
	/**
	 * This method is common to all visitors, but each visitor
	 * perform different operations on same input.
	 * @param dataTree
	 */
	public void visit(DataTreeInterface dataTree);
}
