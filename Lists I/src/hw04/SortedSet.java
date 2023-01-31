package hw04;

import java.util.Arrays;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class is made to take in generic values that can utilize these different methods 
 * Other Comments: No other comments.
 */

public class SortedSet <E extends Comparable<E>> {
	private E[] set;
	private int size; // number of actual elements in the set (not capacity)

	public SortedSet() {
		this.size = 0;
		this.set = (E[])(new Comparable[10]);
	}

	public SortedSet(int capacity) {
		this.size = 0;
		this.set = (E[])(new Comparable[capacity]);
	}

	public SortedSet(E ... values) {
		this.size = 0;
		this.set = (E[])(new Comparable[values.length]);
		this.addAll(values);
	}
	public SortedSet(SortedSet copiedset) {
		this.set = (E[])(new Comparable[copiedset.size]);
		System.arraycopy(copiedset.set, 0, this.set, 0, copiedset.size());
		this.size = copiedset.size();
	}

	//checks if a value exists within the set
	public boolean exists(E value) {
		for(int i = 0; i < this.size; i++){
			if(this.set[i].compareTo(value) == 0){
				return true;
			}
		}
		return false;
	}

	//adds a value to the set given it does not already exist 
	public void add(E value) {
		if(exists(value)) {
			//nothing will happen if a value already exists
		}
		else {
			if(this.size == this.set.length) {
				this.resize();
			}
			this.set[this.size] = value;
			this.size++;
		}
		Arrays.sort(this.set, 0, this.size);
	}

	//create a for loop that increments multiple times to add values into the set
	public void addAll(E ... values) {
		for(int i = 0; i < values.length; i++) {
			this.add(values[i]);
		}
	}

	//removes an item from the array given its value 
	public void remove(E value) {
		int count = 0;
		if(exists(value)) {
			for(int i = 0; i < this.size; i++) { //in this for loop there are three cases to deal with are listed
				if(this.set[i].compareTo(value) == 0) {
					if(this.set[i] == this.set[0]) {//the event the removed item is the beginning 
						this.set[i] = this.set[i+1];
					}
					if(this.set[i] == this.set[this.size - 1]) {//the event the removed item is the last item
						size--;
					}
					else {//the event an item in the middle of the set
						this.set[i] = this.set[i +1];
						size--;
						count++;
					}
				}
				this.set[i] = this.set[i + count];
			}

		}
		else {

		}
	}

	//grab a specific index within the set
	public E get(int index)throws java.lang.IndexOutOfBoundsException {
		if(index < 0) {
			throw new IndexOutOfBoundsException("Index is below lower bound of set");
		}
		if(index >= this.size ) {
			throw new IndexOutOfBoundsException("Index is above upper bound of set ");
		}
		return this.set[index];
	}

	//returns the size of the set
	public int size() {
		return this.size;
	}

	//compares two objects to see if they are equal or not
	@Override
	public boolean equals(Object o) {
		if (o == this.set) {
			return true;
		} 
		else if(o == null || !(o instanceof SortedSet)) {
			return false;
		}
		SortedSet<E> s = (SortedSet<E>) o;
		if(s.size() != this.size()) {
			return false;
		}
		for(int i = 0; i < this.size(); i++) {
			if(s.set[i].compareTo(this.set[i]) == 0) {
				
			}
			else {
				return false;
			}	
		}
		return true;
	}

	//create a toString of all the items in the set
	public String toString() {
		String str = "{";
		if(this.size > 0) {
			for( int i = 0; i < this.size; i++) {
				if(i == this.size - 1) {
					str += this.set[i];
				}
				else {
					str += this.set[i] + ", ";
				}
			}
		}
		str += "}"; 
		return str;
	}

	//resizes the set given that there is not enough space in given set
	private void resize() {
		//double the size so that there is more space for another added item if necessary 
			int doublesize = this.size() * 2;
			E[] holder = (E[])(new Comparable[doublesize]);
			System.arraycopy(this.set, 0, holder, 0, this.size());
			this.set = (E[])(new Comparable[doublesize]);
			System.arraycopy(holder, 0, this.set, 0, this.size());
		

	}
}
