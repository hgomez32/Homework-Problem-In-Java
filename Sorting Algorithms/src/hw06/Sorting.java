package hw06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/* Hugo Gomez

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the sorting class that will sort arraylists and have different ways of doing so
 * Other Comments:no comments
 */
public class Sorting {

	private Sorting() {

	}

	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		int j; 
		for(int i = 1; i < list.size() ; i++) {
			E temp = list.get(i);
			j = i; 
			while( j > 0 && (temp.compareTo(list.get(j - 1)) < 0 )) {
				list.set(j,  list.get(j -1));
				j--;
			}
			list.set(j,  temp);
		}
	}

	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		int size = list.size();
		for(int i = 0; i < size - 1 ; i++) {
			boolean swapped = false;
			for(int j = 0; j < size - 1; j++) {
				if(list.get(j).compareTo((list.get(j+ 1))) > 0) {
					Collections.swap(list, j, j + 1);
					swapped = true;
				}	
			}
			if(!swapped){
				break;
			}
		}
	}

	public static<E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		for(int i = 0; i < list.size() - 1; i++) {
			int min = i;
			for(int j = i + 1; j < list.size() ; j++) {
				if((list.get(j).compareTo(list.get(min))) < 0){
					min = j;
				}
			}
			Collections.swap(list, i, min);
		}
	}

	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		if(list.size() > 1) {
			int mid = (list.size() - 1)/2;
			ArrayList<E> leftlist = new ArrayList<>(); 
			for(int i = 0; i <= mid ; i++) {
				leftlist.add(list.get(i));

			}

			mergeSort(leftlist);


			ArrayList<E> rightlist = new ArrayList<>(); 
			for(int j = mid + 1; j <= list.size() - 1 ; j++) {
				rightlist.add(list.get(j));
			}
			mergeSort(rightlist);

			mergeSort(leftlist, rightlist, list);
		}
	}
	private static <E extends Comparable<E>> void mergeSort(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> result) {
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < list1.size() && j < list2.size()) {
			if(list1.get(i).compareTo(list2.get(j)) < 0) {

				result.set(k, list1.get(i));
				i++;
			}
			else {

				result.set(k, list2.get(j));
				j++;
			}
			k++;
		}
		while(i < list1.size()) {

			result.set(k, list1.get(i));
			i++;
			k++;
		}
		while(j < list2.size()) {

			result.set(k, list2.get(j));
			j++;
			k++;
		}
	}
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list, 0, list.size() - 1);
	}
	private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int low, int high) {
		if(low < high) {
			int p = partition (list, low, high);

			quickSort(list, low, p - 1);
			quickSort(list, p + 1, high);
		}
	}
	private static <E extends Comparable<E>> int partition(ArrayList<E> list, int low, int high) {
		E pivot = list.get(high);
		int i = low - 1;

		for(int j = low; j <= high - 1 ; j++) {
			if(list.get(j).compareTo(pivot) == 0 || list.get(j).compareTo(pivot) < 0 ) {
				i = i + 1;
				Collections.swap(list, i, j);
			}
		}
		Collections.swap(list, i + 1, high);

		return i + 1;
	}

	//works only with integers
	public static void countingSort(ArrayList<Integer> list, int k) {

		Integer[] result = new Integer[list.size()];
		Integer[] counts = new Integer[k];

		for(int i = 0; i <= k - 1; i++) {
			counts[i] = 0;
		}
		for(int i = 0; i <= list.size() - 1; i++) {
			counts[list.get(i)]++;	
		}

		for(int i = 1; i <= k - 1; i++) {
			counts[i] += counts[i - 1];
		}

		for(int i = list.size() - 1; i >= 0; i--) {
			result[counts[list.get(i)] - 1] = list.get(i);

			counts[list.get(i)]--;
		}


		for(int i = 0; i < result.length; i++) {
			list.set(i, result[i]);
		}
	}
	//works only with integers
	public static void radixSort(ArrayList<Integer> list) {
		int numdigits = maxdigits(list);
		List<Integer>[] buckets = new ArrayList[10]; 
		//initialize all of the buckets
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();  
		} 

		for( int i = 1; i  <= 3; i++) {
			for(int j = 0; j <= list.size() - 1; j++) {
				int key = list.get(j) / (int) Math.pow(10, i - 1) % 10;//get the ith least significant digit of list[j]
				buckets[key].add(list.get(j));

			}
			
			int k = 0;
			for(int j = 0; j <= buckets.length - 1; j++) {
				for(int a = 0; a < buckets[j].size(); a++) {
            		list.set(k++, buckets[j].get(a)); // store the buckets within the list 
            	}
				buckets[j].clear();//clear the buckets 
			}
		}

	}

	//finds the number of digits in the largest value in the list 
	private static int maxdigits(ArrayList<Integer> list) {
		Integer max = list.get(0) ;
		for(int i = 0; i < list.size(); i++) {
			if(max.compareTo(list.get(i)) < 0) {
				max = list.get(i);
			}
		}
		int size = String.valueOf(max).length();
		return size;
	}


}


