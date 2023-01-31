package hw07;
/* Hugo Gomez

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: Create a node for the BSTSearchTree class
 * Other Comments:no comments
 */
public class BSTNode<E extends Comparable<E>> {
	protected E data; // store the data here
	protected BSTNode<E> parent; // directional pointer
	protected BSTNode<E> left; // directional pointer
	protected BSTNode<E> right; // directional pointer

	//Constructor which takes an item of any type and initializes the item data field
	public BSTNode(E data) {
		this.data = data;
	}

}
