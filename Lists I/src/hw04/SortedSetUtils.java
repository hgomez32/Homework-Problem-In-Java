package hw04;

/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class tests that the SortedSet class works as well as the SortedSetUtils work 
 * Other Comments:no further comments
 */

public class SortedSetUtils {
	private SortedSetUtils() {
	}

	//add both sorted sets to a SortedSet so that all the elements are within one set
	public static <E extends Comparable<E>> SortedSet<E> union(SortedSet<E> s1, SortedSet<E> s2) {
		SortedSet<E> union = new SortedSet<E>();
		for(int i = 0; i < s1.size(); i++) {
			try {
				union.add(s1.get(i));
			}
			catch(IndexOutOfBoundsException x) {
				System.out.print("Out of bounds index for " + i);
			}
		}
		for(int i = 0; i < s2.size(); i++) {
			try {
				union.add(s2.get(i));
			}
			catch(IndexOutOfBoundsException x) {
				System.out.print("Out of bounds index for " + i);
			}
		}
		return union;
	}
	//find the elements that are the same of this set so that their intersection is produced 
	public static <E extends Comparable<E>> SortedSet<E> intersection(SortedSet<E> s1, SortedSet<E> s2) {
		//in the single for loop all the elements of one set are checked to see if any match with the other set if they match they are added to the intersection set
		SortedSet<E> intersect = new SortedSet<E>();
		for(int i = 0; i < s2.size(); i++) {
			try {
				if(s1.exists(s2.get(i))) {
					intersect.add(s2.get(i));
				}
			}
			catch(IndexOutOfBoundsException x) {
				System.out.print("Out of bounds index for " + i);
			}
		}
		return intersect;
	}
}
