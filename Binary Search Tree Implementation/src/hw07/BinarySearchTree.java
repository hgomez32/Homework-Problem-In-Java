package hw07;
/* Hugo Gomez

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description:This class creates a binary search tree and has various methods to manipulate/ return information in the tree
 * Other Comments:no comments
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> {
	protected BSTNode<E> root ;

	public BinarySearchTree() {
		this.root = null;

	}

	public BinarySearchTree(E ... elements) {
		for (int i = 0; i < elements.length; i++) {
			this.insert(elements[i]);
		}
	}

	public void insert(E value) {
		BSTNode<E> child = new BSTNode<E>(value);

		if(this.root == null) {
			this.root = child;
		}
		else {
			try {
				child.parent = insertionPoint(value);
				if(value.compareTo(child.parent.data) < 0) {
					child.parent.left = child;
				}
				else if(value.compareTo(child.parent.data) > 0) {
					child.parent.right = child;
				}
			}
			catch(Exception ex) {
				System.out.println("Value already exists: " + value);
			}
		}

	}
	private BSTNode<E> insertionPoint(E value) throws Exception{
		BSTNode<E> current = root;
		BSTNode<E> parent = null;

		while(current != null) {
			if(value.compareTo(current.data) == 0) {
				throw new Exception();
			}
			else if(value.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}
			else if(value.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			}
		}
		return parent;
	}

	//delete a value from the BST not using indices 
	public void delete(E value) {
		try{
			delete(nodeToDelete(value));
		}
		catch(Exception ex) {
			System.out.println("Value does not exist within tree : " + value);
		}
	}

	private void delete(BSTNode<E> node) throws Exception {
		//first try to find the value if it exists if not we throw an exception 
		if(find(node.data)) {
			if(isLeaf(node)){
				if(isLeftChild(node)) {
					node.parent.left = null;
				}
				else if(isRightChild(node)) {
					node.parent.right = null;
				}		
			}
			else if(numChildren(node) == 1){
				BSTNode<E> child = null;

				if(node.left != null) {
					child = node.left;
				} else {
					child = node.right;
				}
				if(isLeftChild(node)) {
					node.parent.left = child;
				}
				else if(isRightChild(node)) {
					node.parent.right = child;
				}
			}

			else if(numChildren(node) == 2) {
				BSTNode<E> max = maxLeftSubtree(node);
				node.data = max.data;
				delete(max);
			}

		}
		else {
			throw new Exception();
		}

	}
	private BSTNode<E> nodeToDelete(E value) {
		BSTNode<E> current = this.root;
		BSTNode<E> parent = null;
		while(current != null) {
			if(value.compareTo(current.data) == 0) {
				return current;
			}
			else if(value.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
				current.parent = parent;

			}
			else if(value.compareTo(current.data) > 0){
				parent = current;
				current = current.right;
				current.parent = parent;

			}	

		}
		return null;
	}

	private BSTNode<E> maxLeftSubtree(BSTNode<E> node){
		BSTNode<E> current = node.left;
		if (current == null) {
			return node;
		}
		while(current.right != null) {

			current = current.right;
		}
		return current;
	}
	//returns a boolean value for a given value that exists within the tree
	public boolean find(E value) {
		BSTNode<E> current = root;

		while(current != null) {
			if(value.compareTo(current.data) == 0) {
				return true;
			}
			else if(value.compareTo(current.data) < 0) {
				current = current.left;
			}
			else if(value.compareTo(current.data) > 0){
				current = current.right;
			}
		}
		return false;

	}

	//returns a boolean if there is nothing in the tree
	public boolean isEmpty() {
		return this.root == null ;
	}

	public ArrayList<E> preorder() {
		ArrayList<E> list = new ArrayList<E>();
		list = preorder(this.root);

		return list;
	}

	private ArrayList<E> preorder(BSTNode<E> node) {
		ArrayList<E> arrlist = new ArrayList<E>();
		if(node == null) {
			return arrlist;
		}
		arrlist.add(node.data);
		if(node.left != null)
			arrlist.addAll(preorder(node.left));
		if(node.right != null)
			arrlist.addAll(preorder(node.right));

		return arrlist;
	}

	public ArrayList<E> inorder() {
		ArrayList<E> list = new ArrayList<E>();
		list = inorder(this.root);
		return list;
	}

	private ArrayList<E> inorder(BSTNode<E> node) {
		ArrayList<E> arrlist = new ArrayList<E>();
		if(node == null) {
			return arrlist;
		}
		if(node.left != null)
			arrlist.addAll(inorder(node.left));
		arrlist.add(node.data);
		if(node.right != null)
			arrlist.addAll(inorder(node.right));

		return arrlist;
	}

	public ArrayList<E> postorder() {
		ArrayList<E> list = new ArrayList<E>();
		list = postorder(this.root);
		return list;
	}

	private ArrayList<E> postorder(BSTNode<E> node) {
		ArrayList<E> arrlist = new ArrayList<E>();
		if(node == null) {
			return arrlist;
		}
		if(node.left != null)
			arrlist.addAll(postorder(node.left));
		if(node.right != null)
			arrlist.addAll(postorder(node.right));
		arrlist.add(node.data);

		return arrlist;
	}

	public ArrayList<E> breadthfirst() {
		return breadthfirst(this.root);
	}
	
	private ArrayList<E> breadthfirst(BSTNode<E> root) {
		ArrayList<E> list = new ArrayList<E>();
		Queue<BSTNode<E>> q = new LinkedList<BSTNode<E>>();

		if(root == null) {
			return list;
		}

		q.clear();
		q.add(root);

		while(!q.isEmpty()) {

			BSTNode<E> node = q.remove();
			if(node != null) {

				list.add(node.data);
				q.add(node.left);

				q.add(node.right);
			}
		}
		return list;  
	}

	//checks to see if a node is a leaf of a BST 
	private boolean isLeaf(BSTNode<E> node) {
		if(node.left == null && node.right == null) {
			return true;
		}
		else {
			return false;
		}
	}

	//checks to see if the node child is on the left
	private boolean isLeftChild(BSTNode<E> node) {
		if(node.parent.left != null) {
			return node.parent.left.data.equals(node.data);
		}

		return false;
	}

	//checks to see if the node child is on the right 
	private boolean isRightChild(BSTNode<E> node) {
		if(node.parent.right != null) {
			return node.parent.right.data.equals(node.data);
		}
		return false;
	}

	//checks to see how many children are a node has
	private int numChildren(BSTNode<E> node) {
		int numofchildren = 0;
		if(node.left != null) {
			numofchildren++;

		}
		if(node.right != null) {
			numofchildren++;

		}
		return numofchildren;
	}

	//prints a visual of the Binary Search Tree by appending string values that call each other
	@Override
	public String toString() {
		String str = "";
		if(isEmpty()) {
			str += "There is no tree to be printed";
			return str;
		}
		str += printTree();
		return str;
	}

	private String printTree() {	
		String str = "";

		if (this.root.right != null) {

			str += this.printTree(this.root.right, true, "");
		}

		str += printNodeValue(this.root);

		if (this.root.left != null) {

			str += this.printTree(this.root.left, false, "");
		}

		return str;
	}

	private String printTree(BSTNode<E> node, boolean isRight, String indent) {
		String str = "";
		if (node.right != null) {
			str += printTree(node.right, true, indent + (isRight ? "        " : " |      "));
		}

		str+= indent;

		if (isRight) {
			str += " /";
		}
		else {
			str += " \\";
		}
		str += "----- ";
		str += printNodeValue(node);
		if (node.left != null) {
			str += printTree(node.left, false, indent + (isRight ? " |      " : "        "));
		}
		return str;
	}

	private String printNodeValue(BSTNode<E> node) {
		String str = "";
		if (node == null) {
			str += "<null>";
		}
		else {
			str +=  node.data ;
		}
		str += "\n";	
		return str;
	}

}
