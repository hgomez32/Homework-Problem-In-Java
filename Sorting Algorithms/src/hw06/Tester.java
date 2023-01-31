package hw06;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the main class that will test the different algorithms as well as time how long they take to sort
 * Other Comments: no comments
 */
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
public class Tester {
	
	public static void main(String args[]) {
		
		print50000();
		System.out.println();
		print100000();
		System.out.println();
		print150000();
		System.out.println();
		print200000();
		System.out.println();
		print250000();
		System.out.println();
		printTester();

		
	


	}
	
	//Finds the max value for an ArrayList of type Integer
	public static int max(ArrayList<Integer> data) {
		Integer max = data.get(0) ;
		for(int i = 0; i < data.size(); i++) {
			if(max.compareTo(data.get(i)) < 0) {
				max = data.get(i);
			}
		}
		return max;
		
	}
	//These methods print the various tests on different primitive and object types to ensure the lists are sorted
	public static void printTester() {
		ArrayList<Integer> a;
		
		a = list1();
		
		ArrayList<String> b = new ArrayList<>();
		b = list2();
		
		ArrayList<Long> c = new ArrayList<>();
		c = list3();
		
		System.out.println("Testing that the algorithms do in fact sort the lists");
		System.out.println("INTEGERS----------------------------------");
		System.out.println("Original List: " + a.toString());
		Sorting.bubbleSort(a);
		System.out.println("Bubble Sorted List: " + a.toString());
		a = list1();
		Sorting.selectionSort(a);
		System.out.println("Selected Sorted List: " + a.toString());
		a = list1();
		Sorting.insertionSort(a);
		System.out.println("Insertion Sorted List: " + a.toString());
		a = list1();
		Sorting.mergeSort(a);
		System.out.println("Merge Sorted List: " + a.toString());
		a = list1();
		Sorting.quickSort(a);
		System.out.println("Quick Sorted List: " + a.toString());
		a = list1();
		Sorting.countingSort(a, max(a) + 1);
		System.out.println("Counting Sorted List: " + a.toString());
		System.out.println();
		a = list1();
		Sorting.radixSort(a);
		System.out.println("Radix Sorted List: " + a.toString());
		System.out.println();
		
		System.out.println("Strings----------------------------------");
		System.out.println("Original List: " + b.toString());
		Sorting.bubbleSort(b);
		System.out.println("Bubble Sorted List: " + b.toString());
		b = list2();
		Sorting.selectionSort(b);
		System.out.println("Selected Sorted List: " + b.toString());
		b = list2();
		Sorting.insertionSort(b);
		System.out.println("Insertion Sorted List: " + b.toString());
		b = list2();
		Sorting.mergeSort(b);
		System.out.println("Merge Sorted List: " + b.toString());
		b = list2();
		Sorting.quickSort(b);
		System.out.println("Quick Sorted List: " + b.toString());
		System.out.println();
		
		System.out.println("Long----------------------------------");
		System.out.println("Original List: " + c.toString());
		Sorting.bubbleSort(c);
		System.out.println("Bubble Sorted List: " + c.toString());
		c = list3();
		Sorting.selectionSort(c);
		System.out.println("Selected Sorted List: " + c.toString());
		c = list3();
		Sorting.insertionSort(c);
		System.out.println("Insertion Sorted List: " + c.toString());
		c = list3();
		Sorting.mergeSort(c);
		System.out.println("Merge Sorted List: " + c.toString());
		c = list3();
		Sorting.quickSort(c);
		System.out.println("Quick Sorted List: " + c.toString());
		c = list3();
		Sorting.quickSort(c);
		System.out.println("Quick Sorted List: " + c.toString());
	}
	
	//This method is used to easily access the different files of data
	public static ArrayList<Integer> test(int a){
		if(a == 0) {
		ArrayList <Integer> test = ReadFile.fileReader("ArrayListTest/50000.txt");
		return test;
		}
		if(a == 1) {
			ArrayList <Integer> test = ReadFile.fileReader("ArrayListTest/100000.txt");
			return test;
			}
		if(a == 2) {
			ArrayList <Integer> test = ReadFile.fileReader("ArrayListTest/150000.txt");
			return test;
			}
		if(a == 3) {
			ArrayList <Integer> test = ReadFile.fileReader("ArrayListTest/200000.txt");
			return test;
			}
		if(a == 4) {
			ArrayList <Integer> test = ReadFile.fileReader("ArrayListTest/250000.txt");
			return test;
			}
		else {
		return null;
		}
	}
	
	//The following methods print out the various data sets with the 7 different methods in Sorting Class
	public static void print50000() {
		
		int maxkey = max(test(0)) + 1;
		Instant start1 = Instant.now();
		Sorting.insertionSort(test(0));
		Instant end1 = Instant.now();
		System.out.println("50,000.txt|Time Taken Insertion Sort: " + Duration.between(start1, end1));
		
		Instant start2 = Instant.now();
		Sorting.bubbleSort(test(0));
		Instant end2 = Instant.now();
		System.out.println("50,000.txt|Time Taken Bubble Sort: " + Duration.between(start2, end2));
		
		Instant start3 = Instant.now();
		Sorting.selectionSort(test(0));
		Instant end3 = Instant.now();
		System.out.println("50,000.txt|Time Taken Selection Sort: " + Duration.between(start3, end3));
		
		Instant start4 = Instant.now();
		Sorting.mergeSort(test(0));
		Instant end4 = Instant.now();
		System.out.println("50,000.txt|Time Taken Merge Sort: " + Duration.between(start4, end4));
		
		Instant start5 = Instant.now();
		Sorting.quickSort(test(0));
		Instant end5 = Instant.now();
		System.out.println("50,000.txt|Time Taken Quick Sort: " + Duration.between(start5, end5));
		
		Instant start6 = Instant.now();
		Sorting.countingSort(test(0), maxkey);
		Instant end6 = Instant.now();
		System.out.println("50,000.txt|Time Taken Counting Sort: " + Duration.between(start6, end6));
		
		Instant start7 = Instant.now();
		Sorting.radixSort((test(0)));
		Instant end7 = Instant.now();
		System.out.println("50,000.txt|Time Taken Radix Sort: " + Duration.between(start7, end7));
		
	}
	
	public static void print100000() {
		int maxkey = max(test(1)) + 1;
		Instant start1 = Instant.now();
		Sorting.insertionSort(test(1));
		Instant end1 = Instant.now();
		System.out.println("100,000.txt|Time Taken Insertion Sort: " + Duration.between(start1, end1));
		
		Instant start2 = Instant.now();
		Sorting.bubbleSort(test(1));
		Instant end2 = Instant.now();
		System.out.println("100,000.txt|Time Taken Bubble Sort: " + Duration.between(start2, end2));
		
		Instant start3 = Instant.now();
		Sorting.selectionSort(test(1));
		Instant end3 = Instant.now();
		System.out.println("100,000.txt|Time Taken Selection Sort: " + Duration.between(start3, end3));
		
		Instant start4 = Instant.now();
		Sorting.mergeSort(test(1));
		Instant end4 = Instant.now();
		System.out.println("100,000.txt|Time Taken Merge Sort: " + Duration.between(start4, end4));
		
		Instant start5 = Instant.now();
		Sorting.quickSort(test(1));
		Instant end5 = Instant.now();
		System.out.println("100,000.txt|Time Taken Quick Sort: " + Duration.between(start5, end5));
		
		Instant start6 = Instant.now();
		Sorting.countingSort(test(1), maxkey);
		Instant end6 = Instant.now();
		System.out.println("100,000.txt|Time Taken Counting Sort: " + Duration.between(start6, end6));
		
		Instant start7 = Instant.now();
		Sorting.radixSort((test(1)));
		Instant end7 = Instant.now();
		System.out.println("100,000.txt|Time Taken Radix Sort: " + Duration.between(start7, end7));
	}
	
	public static void print150000() {
		int maxkey = max(test(2)) + 1;
		Instant start1 = Instant.now();
		Sorting.insertionSort(test(2));
		Instant end1 = Instant.now();
		System.out.println("150,000.txt|Time Taken Insertion Sort: " + Duration.between(start1, end1));
		
		Instant start2 = Instant.now();
		Sorting.bubbleSort(test(2));
		Instant end2 = Instant.now();
		System.out.println("150,000.txt|Time Taken Bubble Sort: " + Duration.between(start2, end2));
		
		Instant start3 = Instant.now();
		Sorting.selectionSort(test(2));
		Instant end3 = Instant.now();
		System.out.println("150,000.txt|Time Taken Selection Sort: " + Duration.between(start3, end3));
		
		Instant start4 = Instant.now();
		Sorting.mergeSort(test(2));
		Instant end4 = Instant.now();
		System.out.println("150,000.txt|Time Taken Merge Sort: " + Duration.between(start4, end4));
		
		Instant start5 = Instant.now();
		Sorting.quickSort(test(2));
		Instant end5 = Instant.now();
		System.out.println("150,000.txt|Time Taken Quick Sort: " + Duration.between(start5, end5));
		Instant start6 = Instant.now();
		Sorting.countingSort(test(2), maxkey);
		Instant end6 = Instant.now();
		System.out.println("150,000.txt|Time Taken Counting Sort: " + Duration.between(start6, end6));
		
		Instant start7 = Instant.now();
		Sorting.radixSort((test(2)));
		Instant end7 = Instant.now();
		System.out.println("150,000.txt|Time Taken Radix Sort: " + Duration.between(start7, end7));
	}
	
	public static void print200000() {
		int maxkey = max(test(3)) + 1;
		Instant start1 = Instant.now();
		Sorting.insertionSort(test(3));
		Instant end1 = Instant.now();
		System.out.println("200,000.txt|Time Taken Insertion Sort: " + Duration.between(start1, end1));
		
		Instant start2 = Instant.now();
		Sorting.bubbleSort(test(3));
		Instant end2 = Instant.now();
		System.out.println("200,000.txt|Time Taken Bubble Sort: " + Duration.between(start2, end2));
		
		Instant start3 = Instant.now();
		Sorting.selectionSort(test(3));
		Instant end3 = Instant.now();
		System.out.println("200,000.txt|Time Taken Selection Sort: " + Duration.between(start3, end3));
		
		Instant start4 = Instant.now();
		Sorting.mergeSort(test(3));
		Instant end4 = Instant.now();
		System.out.println("200,000.txt|Time Taken Merge Sort: " + Duration.between(start4, end4));
		
		Instant start5 = Instant.now();
		Sorting.quickSort(test(3));
		Instant end5 = Instant.now();
		System.out.println("200,000.txt|Time Taken Quick Sort: " + Duration.between(start5, end5));
		
		Instant start6 = Instant.now();
		Sorting.countingSort(test(3), maxkey);
		Instant end6 = Instant.now();
		System.out.println("200,000.txt|Time Taken Counting Sort: " + Duration.between(start6, end6));
		
		Instant start7 = Instant.now();
		Sorting.radixSort((test(3)));
		Instant end7 = Instant.now();
		System.out.println("200,000.txt|Time Taken Radix Sort: " + Duration.between(start7, end7));
	}
	
	public static void print250000() {
		int maxkey = max(test(4)) + 1;
		Instant start1 = Instant.now();
		Sorting.insertionSort(test(4));
		Instant end1 = Instant.now();
		System.out.println("250,000.txt|Time Taken Insertion Sort: " + Duration.between(start1, end1));
		
		Instant start2 = Instant.now();
		Sorting.bubbleSort(test(4));
		Instant end2 = Instant.now();
		System.out.println("250,000.txt|Time Taken Bubble Sort: " + Duration.between(start2, end2));
		
		Instant start3 = Instant.now();
		Sorting.selectionSort(test(4));
		Instant end3 = Instant.now();
		System.out.println("250,000.txt|Time Taken Selection Sort: " + Duration.between(start3, end3));
		
		Instant start4 = Instant.now();
		Sorting.mergeSort(test(4));
		Instant end4 = Instant.now();
		System.out.println("250,000.txt|Time Taken Merge Sort: " + Duration.between(start4, end4));
		
		Instant start5 = Instant.now();
		Sorting.quickSort(test(4));
		Instant end5 = Instant.now();
		System.out.println("250,000.txt|Time Taken Quick Sort: " + Duration.between(start5, end5));
		
		Instant start6 = Instant.now();
		Sorting.countingSort(test(4), maxkey);
		Instant end6 = Instant.now();
		System.out.println("250,000.txt|Time Taken Counting Sort: " + Duration.between(start6, end6));
		
		Instant start7 = Instant.now();
		Sorting.radixSort((test(4)));
		Instant end7 = Instant.now();
		System.out.println("250,000.txt|Time Taken Radix Sort: " + Duration.between(start7, end7));
	}
	
	//Below are examples of lists used to ensure that the sorting algorithms work properly and with Generics!
	public static ArrayList<Integer> list1() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(331);
		a.add(454);
		a.add(230);
		a.add(34);
		a.add(343);
		a.add(45);	
		a.add(59);
		a.add(453);
		a.add(345);
		a.add(231);
		a.add(9);
		
		return a;
	}
	
	public static ArrayList<String> list2() {
		ArrayList<String> b = new ArrayList<>();
		
		b.add("Coding");
		b.add("is");
		b.add("for");
		b.add("everyone ^_^");
		return b;
	}
	
	public static ArrayList<Long> list3() {
		ArrayList<Long> c = new ArrayList<>();
		
		c.add((long) 69354);
		c.add((long) 5924);
		c.add((long) 100000);
		c.add((long) 32123);
		c.add((long) 42556);
		c.add((long) 1347);
		return c;
	}
	
}
