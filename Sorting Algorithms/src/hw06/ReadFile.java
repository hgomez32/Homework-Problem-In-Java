package hw06;
/* Hugo Gomez

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class reads the file and parses the file into Integers so that it can be manipulated for the different methods 
 * in the sorting class
 * Other Comments:no comments
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
		private ReadFile(){
			
		}
		public static ArrayList<Integer> fileReader(String filename){
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			try {
				File file = new File(filename);
				Scanner scan = new Scanner(file);
				
				while(scan.hasNextLine()) {
					list.add(Integer.parseInt(scan.nextLine()));
				}
				
				scan.close();
				
			} catch (FileNotFoundException ex) {
				System.out.println("There may be a type or there does not exist such file");
			}
			
			return list;
		}
		


	}

