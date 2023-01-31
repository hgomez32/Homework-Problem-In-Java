/* Hugo Gomez 

 * CS 2013
 * Your Section Numbers: 03 & 04 
 * The purpose of this class is to have something general to be used for the main method 
 * This class is a simple pcpart class that has different parameters along with other methods
 */

package hw02;

public class PCPart implements Comparable<PCPart>{
	private String name;
	private String brand;
	private String partNumber;
	private double price;


	public PCPart(String name, String brand, String partNumber, double price) {
		this.name = name;
		this.brand = brand;
		this.partNumber = partNumber;
		this.price = price;

	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		
		result += "Name:" + this.name + " ";
		result += "Brand:" + this.brand + " ";
		result += "Part#:" + this.partNumber;
		
		return result;
	}

	@Override
	public int compareTo(PCPart o) {
		// TODO Auto-generated method stub
		return 0;
	}

}