package hw04;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class tests that the SortedSet class works as well as the SortedSetUtils work 
 * Other Comments:no further comments
 */
public class Tester {
	public static void main(String[] args) {
		System.out.println("---------------------TESTING INTEGERS-----------------------------");
		integersTest();
		System.out.println("\n\n---------------------TESTING STRINGS-----------------------------");
		stringTest();
		System.out.println("\n\n---------------------TESTING SortedSetUtils-----------------------------");
		utilsTest();
	}
	//create testing for integers
	public static void integersTest() {
		SortedSet<Integer> s1 = new SortedSet<>();
		SortedSet<Integer> s2 = new SortedSet<>(1,2,4,5);
		System.out.println("First set: " + s1.toString());
		System.out.println("Second set: " + s2.toString() + "\n");
		s1.add(1);
		s1.add(2);
		
		System.out.println("Checking add method(adding values 1 & 2): " + s1.toString());
		System.out.println("Checking exits method(checking if 1 exists): " + s1.exists(1));s1.addAll(2,3,4,5);
		System.out.println("Checking addall method(adding 2,3,4,5): " + s1.toString());s1.remove(3);
		System.out.println("Checking remove method(removing 3): " + s1.toString());
		System.out.println("Checking get method(getting [3] which is 5): " + s1.get(3));
		System.out.println("Checking size method: " + s1.size());
		System.out.println("Checking equals method(compared {1,2,4,5} with {1,2,4,5}: " + s1.equals(s2));
		System.out.println("Checking union method:" + SortedSetUtils.union(s1, s2).toString());
		System.out.println("Checking intersection method:" + SortedSetUtils.intersection(s1, s2).toString());

	}
	//create testing method for strings
	public static void stringTest() {
		SortedSet<String> s1 = new SortedSet<>();
		SortedSet<String> s2 = new SortedSet<>("cool");
		System.out.println("First set: " + s1.toString());
		System.out.println("Second set: " + s2.toString() + "\n");
		s1.add("hi");
		System.out.println("Checking add method(adding value \"hi \" ): " + s1.toString());
		System.out.println("Checking exits method(checking if \"hi \" exists): " + s1.exists("hi"));s1.addAll("am", "not", "cool");
		System.out.println("Checking addall method(adding \"am\" , \"not\" , \"cool\"): " + s1.toString());s1.remove("hi");
		System.out.println("Checking remove method(removing \"hi\"): " + s1.toString());
		System.out.println("Checking get method(getting [0] which is \"am\"): " + s1.get(0));
		System.out.println("Checking size method: " + s1.size());
		System.out.println("Checking equals method(compared {\"cool\"} with {\"am\",\"cool\",\"not\"}: " + s1.equals(s2));
		System.out.println("Checking union method: " + SortedSetUtils.union(s1, s2).toString());
		System.out.println("Checking intersection method: " + SortedSetUtils.intersection(s1, s2).toString());
	}
	
	//create testing method for SortedSetUtils 
	public static void utilsTest() {
		SortedSet<String> s1 = new SortedSet<>("Hello", "Professor");
		SortedSet<String> s2 = new SortedSet<>("Hello", "Keenan");
		System.out.println("First set: " + s1.toString());
		System.out.println("Second set: " + s2.toString());
		System.out.println("Checking union method: " + SortedSetUtils.union(s1, s2).toString());
		System.out.println("Checking intersection method: " + SortedSetUtils.intersection(s1, s2).toString());
		System.out.println();
		SortedSet<Double> s3 = new SortedSet<>(1.1,1.2,1.5);
		SortedSet<Double> s4 = new SortedSet<>(2.1,1.1932,8.5);
		System.out.println("Third set: " + s3.toString());
		System.out.println("Fourth set: " + s4.toString());
		System.out.println("Checking union method: " + SortedSetUtils.union(s3, s4).toString());
		System.out.println("Checking intersection method: " + SortedSetUtils.intersection(s3, s4).toString());
	}


}
