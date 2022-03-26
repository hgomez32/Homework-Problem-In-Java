package hw01;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This is the main tester class and this is where we call the object and its methods to create different image files
 * Other Comments:This class was pretty straight forward and is repetitive as in how the methods work
 */

import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		
		menu1();
		
	}
	
	//This method is created to read in a string from the user to read a .ppm file from
	public static void menu1() {
		System.out.println("Type in the file path of images you would like to alter(type \"exit\" to end program):");
		Scanner input = new Scanner(System.in);
		String filepath = input.nextLine();
		String s = "exit";
		
		if(filepath.equals(s)) {
			System.exit(0);
		}
		PPMImage image1 = new PPMImage(filepath);
		menu2(image1);
	
		
		input.close();
	}
	
	//This menu has the choices in which the user may want to alter the pixel data as well as the text 
	public static void menu2(PPMImage image) {
		Scanner input = new Scanner(System.in);
		System.out.println("Choose how you would like to alter the pixel data:");
		System.out.println("1. Sepia");
		System.out.println("2. Greyscale");
		System.out.println("3. Negative");
		System.out.println("4. Go Back");
	
		
		int b = input.nextInt();
		switch(b) {
		case 1: image.sepia();
				createfile(image);
				break;
		case 2: image.grayscale();
				createfile(image);
				break;
		case 3: image.negative();
				createfile(image);
				break;
		case 4: menu1(); // This case allows you to go back to the fist menu
			
				break;
			
		}
		input.close();
	}
	
	//This method takes in a PPMImage object and create a new file to write to which is a method of PPMImage class
	public static void createfile(PPMImage image) {
		Scanner input = new Scanner(System.in);
		System.out.print("Now type in the file name of your newly altered image(no need to add the file extension): ");
		String name = input.nextLine();
		image.writeImage(name + ".ppm");
		System.out.println("Your new file has been created! Hooray!\n");
		
		
		menu1();
		
		
	
		
	
		input.close();
	}
}
