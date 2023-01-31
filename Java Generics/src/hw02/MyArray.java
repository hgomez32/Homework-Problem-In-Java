package hw02;


import java.util.Random;

/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class is able to take in any data type and use any of these methods to.
 * Other Comments: Some of these methods were easy to create however I had difficulty with figuring out the sort method 
 */
public class MyArray<E extends Comparable<E>> {
	private E[] data;

	public MyArray(int size) {
		this.data = (E[])(new Comparable[size]);
	}

	//This constructor can accept an array or a comma-separated list of values.
	public MyArray(E ... elements) {
		this.data = (E[])(new Comparable[elements.length]);
		//Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
	}

	//gets a single value from a list
	public E get(int index) {
		return data[index];
	}

	//gets the data from the list
	public MyArray<E> get(int start, int end) {
		   int size = (end - start) + 1 ;
		   MyArray<E> arr = new MyArray<>(size);
		   int j = 0;
		   for (int i = start; i <= end; i++) {
		       arr.put(j, data[i]);
		       j++;
		   }
		   return arr;
		  
		}

	//puts a value at a given index
	public void put(int index,E value) {
		data[index] = value;
	}	

	//puts a series of data into a list
	public void put(int start, int end, E ... arr) {
		try {
			System.arraycopy(arr, 0 , data, start, arr.length);
		}
		catch(IndexOutOfBoundsException e) {
			System.out.print("Enter valid values.");
		}
	}

	//Checks if two lists are equal
	@Override 
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} 
		else if(o == null || !(o instanceof MyArray)) {
			return false;
		}
		MyArray<E> arr = (MyArray<E>) o;
		if(arr.size() != data.length) {
			return false;
		}
		for(int i = 0; i < arr.size(); i++) {
			if(arr.get(i) == data[i]) {
			}
			else {
				return false;
			}	
		}
		return true;
	}

	//Finds the maximum of a list
	public E max() {
		E max = data[0] ;
		for(int i = 0; i < data.length; i++) {
			if(max.compareTo(data[i]) < 0) {
				max = data[i];
			}
		}
		return max;
	}

	//Finds the minimum of a list
	public E min() {
		E min = data[0];
		for(int i = 0; i < data.length; i++) {
			if(min.compareTo(data[i]) > 0) {
				min = data[i];
			}
		}
		return min;
	}

	//Writes the list in reverse
	public void reverse() {
		E k;
		for(int i = 0; i < data.length/2 ; i++) {
			k = data[i];
			data[i] = data[data.length - i - 1];
			data[data.length - i - 1] = k;
		}

	}

	//Shuffles any given list
	public void shuffle() {
		Random random = new Random();
		for(int i = 0; i < data.length; i++) {
			int index = random.nextInt(data.length);
			E swap = data[i];
			data[i] = data[index];
			data[index] = swap;

		}

	}

	//Moves the list to the left
	public void leftShift(int shiftDistance) {
		for(int i = 0; i < shiftDistance; i++) {
			int j;
			E holder;
			holder = data[0];
			for(j = 0; j < data.length - 1; j++) {
				data[j] = data[j + 1];
			}
			data[j] = holder;
		}
	}

	//Move the list to the right 
	public void rightShift(int shiftDistance ) {
		for(int i = 0; i < shiftDistance; i++) {
			int j;
			E holder;
			holder = data[data.length - 1];
			for(j = data.length - 1; j > 0; j--) {
				data[j] = data[j - 1];
			}
			data[j] = holder;
		}
	}

	//Returns the size of the data stored
	public int size() {
		return data.length;
	}

	//A string of data from the list
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < data.length; i++) {

			if(i == data.length - 1) {
				s += data[i];
			}
			else
				s += data[i] + ", ";
		}
		return s;
	}

	//Sorts the list 
	public void sort() {
		boolean sorted = true;
		do {
			sorted = false;
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i].compareTo(data[i+1]) > 0) {
					E holder = data[i];
					data[i] = data[i + 1];
					data[i + 1] = holder;
					sorted = true;
				}
			}
		} while (sorted);

	}

}

