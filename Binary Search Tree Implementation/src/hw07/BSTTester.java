package hw07;
/* Hugo Gomez

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: Main class which is used to display that the methods in the BianrySearchTree class function properly 
 * Other Comments:no comments
 */
public class BSTTester {

	public static void main(String[] args) {

		
		firstconstructorprint();
		secondconstructorprint();
		
	
		
		
		
	}
	public static void firstconstructorprint() {
		System.out.println("FIRST CONSTRUCTOR TESTING INTEGERS-------------------------------------");
		BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
		System.out.println("Insterting Values: 60, 55, 45, 57, 100, 67, 107" );
		tree2.insert(60);
		tree2.insert(55);
		tree2.insert(45);
		tree2.insert(57);
		tree2.insert(100);
		tree2.insert(67);
		tree2.insert(107);
		System.out.println("Tree Preorder traversal: " + tree2.preorder());
		System.out.println("Tree Inorder traversal: " + tree2.inorder());
		System.out.println("Tree Postorder traversal: " + tree2.postorder());
		System.out.println("Breath First traversal: " + tree2.breadthfirst());
		System.out.print(tree2);
		
		System.out.println("Delete value 100");tree2.delete(100);
		System.out.println("Insert value 125");tree2.insert(125);
		System.out.println("Find value 55: " + tree2.find(55));
		System.out.print(tree2);
	}
	
	public static void secondconstructorprint() {
		System.out.println("\n\nSECOND CONSTRUCTOR TESTING INTEGERS-------------------------------------");
		BinarySearchTree<Integer> tree1 = new BinarySearchTree<>(25,20,22,10,12,15,5,1,8,36,40,48,50,45,38,30,28);

		System.out.println(tree1);
		System.out.println();		
		System.out.println("Find value 16: " + 	tree1.find(16));
		System.out.println("Find value 30: " + 	tree1.find(30));
		System.out.println("Find value 70: " + 	tree1.find(70));
		System.out.println("Find value 90: " + 	tree1.find(90));
		System.out.println("Find value 22: " + 	tree1.find(22));
		System.out.println();
		System.out.println("Insert value 5");tree1.insert(5);
		System.out.println("Insert value 21");tree1.insert(21);
		System.out.println("Insert value 300");tree1.insert(300);
		System.out.println(tree1);	

		System.out.println("Delete value 12");tree1.delete(12);
		System.out.println("Delete value 48");tree1.delete(48);
		System.out.println("Delete value 25");tree1.delete(25);
		System.out.println(tree1);
		System.out.println("Tree Preorder traversal: " + tree1.preorder());
		System.out.println("Tree Inorder traversal: " + tree1.inorder());
		System.out.println("Tree Postorder traversal: " + tree1.postorder());
		System.out.println("Breath First traversal: " + tree1.breadthfirst());
	}

}
