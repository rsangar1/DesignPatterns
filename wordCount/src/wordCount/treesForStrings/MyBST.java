package wordCount.treesForStrings;

import java.util.ArrayList;
import java.util.List;

public class MyBST {

	private Node root;
	
	public MyBST(){
		root = null;
	}
	
	public Node getRoot(){
		return root;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public void insert(String key){
		root = insert(root, key);
	}

	private Node insert(Node node, String key) {
		if(node == null){
			node = new Node(key);
		}else{
			int diff = key.compareTo(node.getKey());
			if(diff<0){
				node.setLeft(insert(node.getLeft(), key));
			}else if(diff> 0)
				node.setRight(insert(node.getRight(), key));
			else{
				node.setValue(node.getValue()+1);
			}
		}
		return node;
	}
	
	public int countNodes(){
		return countNodes(root);
	}
	
	public int countNodes(Node node){
		int count = 0;
		if(node == null)
			count = 0;
		else{
			count = 1;
			count += countNodes(node.getLeft());
			count += countNodes(node.getRight());
		}
		return count;
	}
	
	
	/*public List<Node> getKeyList(){
		return getKeyList(root);
	}
	
	private List<Node> getKeyList(Node node) {
		List<Node> keys = new ArrayList<Node>();
		if(node!=null){
			keys.addAll(getKeyList(node.getLeft()));
			keys.add(node);
			keys.addAll(getKeyList(node.getRight()));
		}
		return keys;
	}*/
}