package hw05;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the generic node class which holds the item in a node which is later used
 * to link other nodes to one another.
 * Other Comments: No other comments.
 */
 public class Array2DNode<E> {
	private E item; // store the data here
	protected Array2DNode<E> nextCol; // directional pointer
	protected Array2DNode<E> nextRow; // directional pointer
	
	//default constructor 
	public Array2DNode() {
	}
	
	//Constructor which takes an item of any type and initializes the item data field
	public Array2DNode(E item) {
		this.item = item;
	}
	
	public E get() {
		return this.item;
	}
	
	public void set(E item) {
		this.item = item;
	}
	

}
