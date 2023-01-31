package hw05;

import java.util.ArrayList;



/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class had different methods which alter the 2D array using nodes, shifting, and so on.
 * Other Comments: 
 */

public class Array2D<E> {
	private int rows;//number of rows
	private int cols;//number of columns
	private Array2DNode<E> head;//head reference pointer
	private Array2DNode<E> rowTail;//row tail reference pointer
	private Array2DNode<E> colTail;//column tail reference pointer

	public Array2D() {
		this.rows = 0;
		this.cols = 0;
		this.head = this.rowTail = this.colTail = null;

	}

	public Array2D(int rows, int cols) throws IndexOutOfBoundsException {
		
		if(rows < 0 ) {
			throw new IndexOutOfBoundsException("Index is out of bounds for row: " + rows);
		}
		if(cols < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds for column: " + cols);
		}
		while(this.rows < rows) {
			addFirstRow();

		}
		while(this.cols < cols) {
			addFirstCol();
		}
	}
	public Array2D(E[][] arr) {
		int countrows = 0;
		int countcols = 0;
		while(countrows < arr.length) {
			addFirstRow();
			countrows++;
		}
		while(countcols < arr[0].length - 1) {
			addFirstCol();
			countcols++;
		}

		//add all values of 2D array to the linked list 
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.set(i, j, arr[i][j]);
			}
		}
	}


	public void addFirstCol() {
		Array2DNode<E> temp = new Array2DNode<E>();

		if(isEmpty()) {
			this.head = this.rowTail = this.colTail = temp;
			this.rows++;
			this.cols++;
		}
		else {

			temp.nextCol = this.head;
			this.head = temp;
			Array2DNode<E> curr = this.head;
			Array2DNode<E> oldhead = temp.nextCol;
			int count = 0;
			while( count < this.rows - 1) {
				curr.nextRow = new Array2DNode<E>();
				curr = curr.nextRow;
				curr.nextCol = oldhead.nextRow;
				oldhead = oldhead.nextRow;
				count++;
			}
			findColTail();
			findRowTail();
			this.cols++;
		}	
	}

	public void addFirstRow() {
		Array2DNode<E> temp = new Array2DNode<E>();

		if(isEmpty()) {
			this.head = this.rowTail = this.colTail = temp;
			this.rows++;
			this.cols++;
		}
		else if(this.rows == 0 && this.cols > 0) {
			temp.nextCol = this.head;
			this.head = temp;
			int count = 0;
			Array2DNode<E> curr = this.head;

			while(count < this.cols - 1) {
				curr.nextCol = new Array2DNode<>();
				curr = curr.nextCol; 

				count++;
			}
			this.rows++;
		}
		else {
			temp.nextRow = this.head;
			this.head = temp;
			Array2DNode<E> curr = this.head;
			Array2DNode<E> oldhead = temp.nextRow;
			int count = 0;
			while(count < this.cols - 1) {
				curr.nextCol = new Array2DNode<>();
				curr = curr.nextCol; 
				curr.nextRow = oldhead.nextCol;
				oldhead = oldhead.nextCol;
				count++;
			}
			findColTail();
			findRowTail();
			this.rows++; 
		}
	}

	public void addLastCol() {
		Array2DNode<E> temp = new Array2DNode<E>();

		if(isEmpty()) {
			this.head = this.rowTail = this.colTail = temp;
			this.rows++;
			this.cols++;
		}
		else {
			Array2DNode<E> curr = this.head;
			while(curr.nextCol != null) {
				curr = curr.nextCol;
			}
			curr.nextCol = temp;
			int count = 0;
			while(count < this.rows - 1) {
				temp.nextRow = new Array2DNode<E>();
				temp = temp.nextRow;
				curr = curr.nextRow;
				curr.nextCol = temp;
				count++;
			}
			findColTail();
			findRowTail();
			this.cols++;
		}	 
	}

	public void addLastRow() {
		if (this.head == null) {
			this.addFirstRow();
		}

		else {
			Array2DNode<E> temp = new Array2DNode<E>();
			Array2DNode<E> curr = this.head;
			while(curr.nextRow != null) {
				curr = curr.nextRow;
			}
			curr.nextRow = temp;

			int count = 0;
			while(count < this.cols - 1) {
				temp.nextCol= new Array2DNode<E>();
				temp = temp.nextCol;
				curr = curr.nextCol;
				curr.nextRow = temp;
				count++;
			}
			findColTail();
			findRowTail();
			this.rows++;
		}	 


	}

	public void insertCol(int index) {
		if (index < 0 || index > this.cols) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		Array2DNode<E> temp = new Array2DNode<E>();


		if(index == 0) {
			this.addFirstCol();
		}
		else if(index == this.cols) {
			this.addLastCol();
		}
		else {
			Array2DNode<E> curr = this.head;
			int count = 0;

			//transverse through the nodes to get to the node before the index 
			while(count < index - 1) {
				curr = curr.nextCol;
				count++;
			}
			Array2DNode<E> currcopy = curr.nextCol;
			temp.nextCol = curr.nextCol;

			curr.nextCol = temp;
			Array2DNode<E> tempcopy = curr.nextCol;


			int counter = 0;
			while(counter < this.rows - 1) {
				temp.nextRow = new Array2DNode<E>();
				temp = temp.nextRow;
				curr = curr.nextRow;
				curr.nextCol = temp;

				counter++;
			}

			int count2 = 0;
			while(count2 < this.rows - 1) {
				tempcopy = tempcopy.nextRow;
				currcopy = currcopy.nextRow;
				tempcopy.nextCol = currcopy;
				count2++;
			}
			
			findColTail();
			findRowTail();
			this.cols++;
		}	
	}

	public void insertRow(int index) {
		if (index < 0 || index > this.rows) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		Array2DNode<E> temp = new Array2DNode<E>();


		if(index == 0) {
			this.addFirstRow();
		}
		else if(index == this.rows) {
			this.addLastRow();
		}
		else {
			Array2DNode<E> curr = this.head;
			int count = 0;

			//transverse through the nodes to get to the node before the index 
			while(count < index - 1) {
				curr = curr.nextRow;
				count++;
			}
			Array2DNode<E> currcopy = curr.nextRow;
			temp.nextRow = curr.nextRow;

			curr.nextRow = temp;
			Array2DNode<E> tempcopy = curr.nextRow;


			int counter = 0;
			while(counter < this.cols - 1) {
				temp.nextCol = new Array2DNode<E>();
				temp = temp.nextCol;
				curr = curr.nextCol;
				curr.nextRow = temp;

				counter++;
			}

			int count2 = 0;
			while(count2 < this.cols - 1) {
				tempcopy = tempcopy.nextCol;
				currcopy = currcopy.nextCol;
				tempcopy.nextRow = currcopy;
				count2++;
			}
			findColTail();
			findRowTail();
			this.rows++;
		}
	}

	public void deleteFirstCol() throws RuntimeException {

		if(isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}
		else {
			if(this.cols == 1) {
				
				this.head = this.colTail = this.rowTail = null;
				this.cols = 0;
				this.rows = 0;
			}
			else {
				this.head = this.head.nextCol;
				this.cols--;
			}
			findColTail();
			findRowTail();
		}
	}

	public void deleteFirstRow() throws RuntimeException {
		if(isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}

		if(this.rows == 1) {
			
			this.head = this.colTail = this.rowTail = null;
			this.cols = 0;
			this.rows = 0;
		}
		else {
			this.head = this.head.nextRow;
			this.rows--;
		}
		findColTail();
		findRowTail();

	}

	public void deleteLastCol()throws RuntimeException {
		if (this.isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}

		if(this.cols == 1) {
			this.head = this.colTail = this.rowTail = null;
			this.rows = 0;
		}
		else {
			Array2DNode<E> current = this.head;
			Array2DNode<E> previous = this.head;

			while(current.nextCol != null) {
				previous = current;
				current = current.nextCol;
			}

			previous.nextCol = null;
			this.colTail = previous;
			int count = 0;
			while(count < this.rows - 1) {
				previous = previous.nextRow;
				previous.nextCol = null;
				count++;
			}


		}
		findColTail();
		findRowTail();

		this.cols--;


	}
	public void deleteCol(int index)throws RuntimeException {
		if (index < 0 || index >= this.cols) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		if (this.isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}

		if(index == 0) {
			deleteFirstCol();
		}
		else if(index == this.cols - 1) {
			deleteLastCol();
		}
		else {
			Array2DNode<E> previous = this.head;
			int count = 0;

			//transverse through the nodes to get to the node before the index 
			while(count < index - 1) {
				previous = previous.nextCol;
				count++;
			}

			previous.nextCol = previous.nextCol.nextCol;
			int count3 = 0;
				
			while(count3 < this.rows - 1) {
				previous = previous.nextRow;
				previous.nextCol = previous.nextCol.nextCol;
				count3++;
			}
			
			findColTail();
			findRowTail();
			this.cols--;
		}	
	}



	public void deleteRow(int index) {
		if (index < 0 || index >= this.rows) {
			throw new IndexOutOfBoundsException("Index is out of bounds for index value: " + index);
		}
		
		
		if (this.isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}

		if(index == 0) {
			deleteFirstRow();
		}
		else if(index == this.rows - 1) {
			deleteLastRow();
		}
		else {
			Array2DNode<E> previous = this.head;
			int count = 0;

			//transverse through the nodes to get to the node before the index 
			while(count < index - 1) {
				previous = previous.nextRow;
				count++;
			}

			previous.nextRow = previous.nextRow.nextRow;
			int count3 = 0;
				
			while(count3 < this.cols - 1) {
				previous = previous.nextCol;
				previous.nextRow = previous.nextRow.nextRow;
				count3++;
			}
			
			findColTail();
			findRowTail();
			this.rows--;
		}	
	}

	public void deleteLastRow()throws RuntimeException {
		if (this.isEmpty()) {
			throw new RuntimeException("Nothing to delete in linked list");
		}
		if(this.rows == 1) {
			this.head = this.colTail = this.rowTail = null;
			this.cols = 0;
		}
		else {
			Array2DNode<E> current = this.head;
			Array2DNode<E> previous = this.head;

			while(current.nextRow != null) {
				previous = current;
				current = current.nextRow;
			}

			previous.nextRow = null;
			this.rowTail = previous;
			int count = 0;
			while(count < this.cols - 1) {
				previous = previous.nextCol;
				previous.nextRow = null;
				count++;
			}


		}
		findColTail();
		findRowTail();

		this.rows--;

	}

	public E get(int row, int col)throws IndexOutOfBoundsException {
		if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
			throw new IndexOutOfBoundsException("Index out of bounds for value " + row + " or " + col );

		}
		Array2DNode<E> curr = this.head;
		int rowcount = 0;
		int colcount = 0;

		while(colcount < col ) {
			while(rowcount < row ) {
				curr = curr.nextRow;
				rowcount++;
			}
			curr = curr.nextCol;
			colcount++;
		}


		return curr.get();
	}

	public ArrayList<E> getCol(int col){
		if (col < 0 || col >= this.cols) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		ArrayList<E> colvals = new ArrayList<E>();
		Array2DNode<E> curr = this.head;

		int currcol = 0;

		while(currcol < col ) {
			curr = curr.nextCol;
			currcol++;

		}
		while(curr != null) {
			colvals.add(curr.get());
			curr = curr.nextRow;

		}

		return colvals;

	}

	public ArrayList<E> getRow(int row){
		if (row < 0 || row >= this.rows) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		ArrayList<E> rowvals = new ArrayList<E>();
		Array2DNode<E> curr = this.head;

		int currrow = 0;

		while(currrow < row ) {
			curr = curr.nextRow;
			currrow++;

		}
		while(curr != null) {
			rowvals.add(curr.get());
			curr = curr.nextCol;

		}

		return rowvals;

	}


	public void set(int row, int col, E item) {
		if(row < 0 || row >= this.rows || col < 0 || col >= this.cols) {
			throw new IndexOutOfBoundsException("Index out of bounds for value " + row + " or " + col );

		}
		Array2DNode<E> curr = this.head;
		int rowcount = 0;
		int colcount = 0;


		while(rowcount < row ) {
			curr = curr.nextRow;
			rowcount++;
		}

		while(colcount < col ) {
			curr = curr.nextCol;
			colcount++;
		}
		curr.set(item); 
	}

	
	public int colSize() {
		return this.cols;
	}
	
	public int rowSize() {
		return this.rows;
	}
	
	private boolean isEmpty() {
		return (this.cols == 0 && this.rows == 0 && this.head == null
				&& this.rowTail == null && this.colTail == null);
	}


	private void findColTail() {
		Array2DNode<E> curr = this.head;

		if(isEmpty()) {

		}
		else {

			if(curr.nextRow == null) {
				this.colTail = curr;
			}
			else {
				while(curr.nextCol != null) {
					curr = curr.nextCol;
				}
				this.colTail = curr;
			}
		}
	}


	private void findRowTail() {
		Array2DNode<E> curr = this.head;
		if(isEmpty()) {

		}
		else {
			if(curr.nextCol == null) {
				this.rowTail = curr;
			}
			else {
				while(curr.nextRow != null) {
					curr = curr.nextRow;
				}
				this.rowTail = curr;
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		Array2DNode<E> rowStart = this.head;
		Array2DNode<E> current = this.head;
		while(rowStart != null) {
			while(current != null) {

				str += current.get() + " ";
				current = current.nextCol;

			}
			str += "\n";
			rowStart = rowStart.nextRow;
			current = rowStart;

		}
		if(isEmpty()) {

			str += "Head Node: " + null;
			str += "\nRow Tail Node: " + null;
			str += "\nColumn Tail Node: " + null;
			str += "\nNumber of cols: " + this.cols;
			str += "\nNumber of rows: " + this.rows;
		}
		else {

			str += "Head Node: " + this.head.get();
			str += "\nRow Tail Node: " + this.rowTail.get();
			str += "\nColumn Tail Node: " + this.colTail.get();
			str += "\nNumber of cols: " + this.cols;
			str += "\nNumber of rows: " + this.rows;
		}

		return str;
	}
}