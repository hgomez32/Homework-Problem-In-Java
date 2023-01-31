package hw02;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the main class where everything is printed and everything is printed. 
 * Other Comments: I was not sure on how the methods were supposed to be tested so I called all the methods here. I use 3 different types of classes to test 
 * my MyArray class.
 */

public class Main {
	public static void main(String args[]) {
		stringData();//Testing String data type
		integer1Data();//Testing Integer data type
		integer2Data();//Testing Integer data type
		pcData();//Testing PC Objects
	}

	public static void stringData() {
		MyArray<String> str = new MyArray<>("yes", "maybe", "no", "hello");
		MyArray<String> newstr = str.get(0, 2);
		System.out.println("STRING DATA TYPE: " );
		System.out.println("Original List: " + str.toString());
		System.out.println("The maximum of list: " + str.max());
		System.out.println("The minimum of list: " + str.min()); str.reverse();
		System.out.println("The reverse of list: " + str.toString());str.shuffle();
		System.out.println("The shuffle of list: " + str.toString()); str.put(0,"im new");
		System.out.println("Switch value at index 0 -> im new : " + str.toString());str.leftShift(2);
		System.out.println("Left Shift 2 times: "+ str.toString());str.rightShift(2);
		System.out.println("Right Shift 2 times: " + str.toString());str.put(1, 2, "HELLO");
		System.out.println("Put method with a series of values being Hello ,There : " + str.toString());
		System.out.println("The size of the list is: " + str.size());
		System.out.println("Get one element at index 0: " + str.get(0));
		System.out.println("Getting elements from index 0 - 2: " + str.toString());
		str.sort();
		System.out.println("Sorted list: " + str.toString());
	}

	public static void integer1Data() {
		MyArray<Integer> number2 = new MyArray<>(4, 13, 2, 124, 5);
		MyArray<Integer> number1 = new MyArray<>(2, 4, 5, 10, 7);
		MyArray<Integer> newnumber1 = number1.get(2, 4);
		System.out.println("\nINTEGER DATA TYPE: " );
		System.out.println("Original List: " + number1.toString());
		System.out.println("The maximum of list: " + number1.max());
		System.out.println("The minimum of list: " +number1.min());number1.reverse();
		System.out.println("The reverse of list: " + number1.toString()); number1.shuffle();
		System.out.println("The shuffle of list: " + number1.toString());number1.put(2,33);
		System.out.println("Switch value at index 2 to 33 : " + number1.toString());number1.leftShift(3);
		System.out.println("Left Shift 3 times: "+ number1.toString());number1.rightShift(1);
		System.out.println("Right Shift 1 times: " + number1.toString());number1.put(0, 2, 1,2,3);
		System.out.println("Put method with a series of values 1,2,3 : " + number1.toString());
		System.out.println("The size of the list is: " + number1.size());number1.sort();
		System.out.println("Getting elements from index 2 - 4: " + newnumber1.toString());
		System.out.println("Sorted list: " + number1.toString());
		System.out.println("Checking if number1 list is equal to number2 list: " + number1.equals(number2));
		
	}
	public static void integer2Data() {
		MyArray<Integer> number2 = new MyArray<>(4, 13, 2, 124, 5);
		MyArray<Integer> newnumber2 = number2.get(1, 3);
		System.out.println("\nINTEGER DATA TYPE: " );
		System.out.println("Original List: " + number2.toString());
		System.out.println("The maximum of list: " + number2.max());
		System.out.println("The minimum of list: " +number2.min());number2.reverse();
		System.out.println("The reverse of list: " + number2.toString()); number2.shuffle();
		System.out.println("The shuffle of list: " + number2.toString());number2.put(4,75);
		System.out.println("Switch value at index 4 to 75 : " + number2.toString());number2.leftShift(2);
		System.out.println("Left Shift 2 times: "+ number2.toString()); number2.rightShift(1);
		System.out.println("Right Shift 1 times: " + number2.toString());number2.put(0, 2, 15,16,17);
		System.out.println("Put method with a series of values 15,16,17 : " + number2.toString());
		System.out.println("The size of the list is: " + number2.size());number2.sort();
		System.out.println("Getting elements from index 1 - 3: " + newnumber2.toString());
		System.out.println("Sorted list: " + number2.toString());
	}

	public static void pcData() {
		PCPart case1 = new PCPart("NXZT H510", "NZXT","CA-H510B-W1",69.98);
		PCPart case2 = new PCPart("Lian Li PC-011 Dynamic", "Lian Li","PC-011DX",139.99);
		PCPart case3 = new PCPart("Coolor Master MasterBox TD500 Mesh", "Coolor Master","MCB-D500D-WGNN-S01",89.99);
		PCPart case4 = new PCPart("NO PART", "NO PART","NO PART",0.00);
		MyArray<PCPart> pc = new MyArray<>(case1,case2,case3);
		MyArray<PCPart> newpc = pc.get(0, 2);
		
		System.out.println("\nPC OBJECT: " );
		System.out.println("Original List: \n" + pc.toString());
		System.out.println("\nThe maximum of list: \n" + pc.max());
		System.out.println("\nThe minimum of list: \n" +pc.min());pc.reverse();
		System.out.println("\nThe reverse of list: \n" + pc.toString()); pc.shuffle();
		System.out.println("\nThe shuffle of list: \n" + pc.toString()); pc.leftShift(5);
		System.out.println("\nLeft Shift 5 times: \n"+ pc.toString()); pc.rightShift(2);
		System.out.println("\nRight Shift 2 times: \n" + pc.toString());pc.put(0, 2, case3,case4,case1);
		System.out.println("\nPut method with a series of values case3,case4,case1 : \n" + pc.toString());
		System.out.println("\nThe size of the list is: \n" + pc.size());pc.sort();
		System.out.println("\nGetting elements from index 0 - 1: \n" + newpc.toString());
		System.out.println("\nSorted list: \n" + pc.toString());
		System.out.println("Checking if pc list is equal to newpc list: " + pc.equals(newpc));
	}
}
