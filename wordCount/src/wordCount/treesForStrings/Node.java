package wordCount.treesForStrings;

public class Node {
	private String key;
	private int value;
	private Node left;
	private Node right;
	
	public Node(){
		key = "";
		value = 0;
		left = null;
		right = null;
	}


	public Node(String key){
		this.key = key;
		this.value = 1;
		left = null;
		right = null;
	}
	
	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
