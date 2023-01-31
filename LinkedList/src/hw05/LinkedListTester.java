package hw05;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the main class where Array2D is tested to ensure that all methods of that class are functioning 
 * Other Comments: No other comments.
 */
public class LinkedListTester {

	public static void main(String[] args) {
	
		
	
		Array2D<Character> arr = new Array2D<Character>();
		System.out.println("TESTING CHARACTERS DATA TYPE(DEFAULT CONSTRUCTOR)----------------------------------------- ");
		arr.addFirstCol();
		arr.addFirstCol();
		arr.addFirstCol();
		arr.addFirstCol();
		arr.addFirstRow();
		arr.addFirstRow();
		arr.addFirstRow();
		System.out.println(arr.getRow(0) + "\n" + arr.getRow(1) + "\n" + arr.getRow(2) + "\n" + arr.getRow(3));
		System.out.println("# of columns = " + arr.colSize() + ", # of rows = " + arr.rowSize());
		arr.addFirstCol();
		System.out.println("Add First Column Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize()); arr.addFirstRow();
		System.out.println("Add First Row Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.addLastCol();
		System.out.println("Add Last Column Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.addLastRow();
		System.out.println("Add Last Row Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.insertCol(1);
		System.out.println("Insert Col at index = 1: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.insertRow(2);
		System.out.println("Insert Row at index = 2: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.deleteFirstCol();
		System.out.println("Delete First Column Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.deleteFirstRow();
		System.out.println("Delete First Row Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.deleteLastCol();
		System.out.println("Delete Last Column Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize()); arr.deleteLastRow();
		System.out.println("Delete Last Row Method: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.deleteCol(0);
		System.out.println("Delete Column at index = 1: columns = " + arr.colSize() + ", rows = " + arr.rowSize());arr.deleteRow(3);
		System.out.println("Delete Row at index = 3: columns = " + arr.colSize() + ", rows = " + arr.rowSize());
		System.out.println("Get Method at column = 1 and row = 1: " + arr.get(1, 1));
		System.out.println("Get Column at index 2:" + arr.getCol(2));
		System.out.println("Get Row at index 0:" + arr.getRow(0)); arr.set(3, 0, 'A');
		System.out.println("Set Method at row = 3, column = 0, and item = 'A' "  );
		System.out.println(arr.getRow(0) + "\n" + arr.getRow(1) + "\n" + arr.getRow(2) + "\n" + arr.getRow(3));
		System.out.println("Number of Columns: " + arr.colSize());
		System.out.println("Number of Rows: " + arr.rowSize() + "\n\n");
		
		
		System.out.println("TESTING INTEGERS DATA TYPE(SECOND CONSTRUCTOR)----------------------------------------- ");
		Array2D<Integer> arr2 = new Array2D<Integer>(4,4);
		System.out.println(arr2.getRow(0) + "\n" + arr2.getRow(1) + "\n" + arr2.getRow(2) + "\n" + arr2.getRow(3));
		System.out.println("# of columns = " + arr2.colSize() + ", # of rows = " + arr2.rowSize());
		arr2.addFirstCol();
		System.out.println("Add First Column Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize()); arr2.addFirstRow();
		System.out.println("Add First Row Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.addLastCol();
		System.out.println("Add Last Column Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.addLastRow();
		System.out.println("Add Last Row Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.insertCol(0);
		System.out.println("Insert Col at index = 0: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.insertRow(1);
		System.out.println("Insert Row at index = 1: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.deleteFirstCol();
		System.out.println("Delete First Column Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.deleteFirstRow();
		System.out.println("Delete First Row Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.deleteLastCol();
		System.out.println("Delete Last Column Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize()); arr2.deleteLastRow();
		System.out.println("Delete Last Row Method: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.deleteCol(2);
		System.out.println("Delete Column at index = 2: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());arr2.deleteRow(1);
		System.out.println("Delete Row at index = 1: columns = " + arr2.colSize() + ", rows = " + arr2.rowSize());
		System.out.println("Get Method at column = 2 and row = 2: " + arr2.get(2, 2));
		System.out.println("Get Column at index 2:" + arr2.getCol(2));
		System.out.println("Get Row at index 1:" + arr2.getRow(1)); arr2.set(3, 3, 7);
		System.out.println("Set Method at row = 3, column = 3, and item = 7 "  );
		System.out.println(arr2.getRow(0) + "\n" + arr2.getRow(1) + "\n" + arr2.getRow(2) + "\n" + arr2.getRow(3));
		System.out.println("Number of Columns: " + arr2.colSize());
		System.out.println("Number of Rows: " + arr2.rowSize() + "\n\n");
//		
//		
//		
//		
		System.out.println("TESTING INTEGERS DATA TYPE(THIRD CONSTRUCTOR)----------------------------------------- ");
		Integer[][] arr2d = { { 1, 2 , 3}, { 4, 5, 6 } ,{ 7, 8, 9 }};
		
		Array2D<Integer> arr3 = new Array2D<Integer>(arr2d);
		System.out.println(arr3);
		System.out.println(arr3.getRow(0) + "\n" + arr3.getRow(1) + "\n" + arr3.getRow(2));
		System.out.println("# of columns = " + arr3.colSize() + ", # of rows = " + arr3.rowSize());
		arr3.addFirstCol();
		System.out.println(arr3);
		System.out.println("Add First Column Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize()); arr3.addFirstRow();
		System.out.println(arr3);
		System.out.println("Add First Row Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.addLastCol();
		System.out.println(arr3);
		System.out.println("Add Last Column Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.addLastRow();
		System.out.println(arr3);
		System.out.println("Add Last Row Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.insertCol(0);
		System.out.println(arr3);
		System.out.println("Insert Col at index = 0: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.insertRow(1);
		System.out.println(arr3);
		System.out.println("Insert Row at index = 1: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.deleteFirstCol();
		System.out.println(arr3);
		System.out.println("Delete First Column Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.deleteFirstRow();
		System.out.println(arr3);
		System.out.println("Delete First Row Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.deleteLastCol();
		System.out.println(arr3);
		System.out.println("Delete Last Column Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize()); arr3.deleteLastRow();
		System.out.println(arr3);
		System.out.println("Delete Last Row Method: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.deleteCol(2);
		System.out.println(arr3);
		System.out.println("Delete Column at index = 2: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());arr3.deleteRow(1);
		System.out.println(arr3);
		System.out.println("Delete Row at index = 1: columns = " + arr3.colSize() + ", rows = " + arr3.rowSize());
		System.out.println(arr3);
		System.out.println("Get Method at column = 1 and row = 1: " + arr3.get(1, 1));
		System.out.println(arr3);
		System.out.println("Get Column at index 1:" + arr3.getCol(1));
		System.out.println(arr3);
		System.out.println("Get Row at index 2:" + arr3.getRow(2)); arr3.set(2, 2, 5);
		System.out.println(arr3);
		System.out.println("Set Method at row = 2, column = 2, and item = 5");
		System.out.println(arr3);
		System.out.println(arr3.getRow(0) + "\n" + arr3.getRow(1) + "\n" + arr3.getRow(2));
		System.out.println("Number of Columns: " + arr3.colSize());
		System.out.println("Number of Rows: " + arr3.rowSize() + "\n\n");
		
//		
		
		
		
	}
	
}


