package hw01;
/* Hugo Gomez
 * CS 2013
 * Your Section Numbers: 03 & 04 
 * Description: This class takes in the original .ppm file and reads it. After reading it, it's information is stored in the different variables.
 * After storing the information we are able to rewrite the data (altered data) into a new file. 
 * Other Comments: I found most difficult trying to read the header line. I was able to figure it out down the line but it was constant testing which loops 
 * would be the best to split the char values and store them into a variable to hold the entire number.
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class PPMImage {
	private String magicNumber; // represents P6
	private int width; // width of the image
	private int height; // height of the image
	private int maxColorValue; // max color value
	private char raster[] = new char[3 * width * height]; // holds pixel data 
	
	public PPMImage(String imageFileName) {
			readImage(imageFileName);//read the original .ppm file to read data from and store it in our variables and array
	}
	
	//writes changed pixels and header of the .ppm file to a new file which the user chooses the name for
	public void writeImage(String outputImageFileName) {
		
		try {
			BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(new File(outputImageFileName)));
			// use a string to bring together all the byte data needed for the header of the .ppm file
			String s = magicNumber + '\n' + width+ ' ' + height + '\n' + maxColorValue + '\n';
			byte[] headerData = s.getBytes();
			fos.write(headerData);
			
			// use  a for each to run through all the pixel data 
			for(char a: raster) {
				fos.write(a);
			}
			
			fos.flush();
			fos.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	private void readImage(String imageFileName) {
		
		try {
			BufferedInputStream fis = new BufferedInputStream(new FileInputStream(new File(imageFileName)));
			
			char ch1 = (char)fis.read();
			char ch2 = (char)fis.read();
			char ch3 = (char)fis.read();//allow this char to store the linefeed so that when we read the data we start from the second line in the file
			magicNumber = "" + ch1 + ch2;// read the first two bytes of data and store them in characters to put them in a string
			
			//create strings to hold each char and then parse them from a string so they can hold int values for width, height, and maxcolorvalue
			char s ;
			String wsize = "";
			String hsize = "";
			String colorsize = "";
			while( (s = (char)fis.read()) != ' ' ) {
				wsize += s;
			}
			while( (s = (char)fis.read()) != '\n' ) {
				hsize += s;	
			}
			while( (s = (char)fis.read()) != '\n' ) {
				colorsize += s;
			}
			
			width = Integer.parseInt(wsize);
			height = Integer.parseInt(hsize);
			maxColorValue = Integer.parseInt(colorsize);
			raster = new char[3*width * height];
			for(int i =0; i< raster.length; i++) {
			
				raster[i] = (char)fis.read();
			}

			fis.close();
			
		}
		catch(FileNotFoundException e){
			System.out.print("\nFile may have been mistyped or nonexistent");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(NumberFormatException e) {
			
		}
	}
	
	//creates a gray image
	public void grayscale() {
		int r;
		int g;
		int b;
		for(int i = 0; i<raster.length; i+= 3) {
			r = (int)raster[i];
			g = (int)raster[i +1];
			b = (int)raster[i + 2];
			
			double grayr = (r * .299) + (g * .587) + (b * .114);
			double grayg = (r * .299) + (g * .587) + (b * .114);
			double grayb = (r * .299) + (g * .587) + (b * .114);
			
			if( grayr >= 255) {
				grayr = 255;
			}
			if( grayg >= 255) {
				grayg = 255;
			}
			if( grayb >= 255) {
				grayb = 255;
			}
			
			raster[i] = (char) grayr;
			raster[i +1] = (char)grayg;
			raster[i + 2] = (char)grayb;
		}
		
	}
	
	//creates a tanish looking image
	public void sepia() {
		int r;
		int g;
		int b;
		for(int i = 0; i<raster.length; i+= 3) {
			r = (int)raster[i];
			g = (int)raster[i +1];
			b = (int)raster[i + 2];
			
			double sepiar = (r * .393) + (g *.769) + (b * .189);
			double sepiag = (r * .349) + (g *.686) + (b * .168);
			double sepiab = (r * .272) + (g *.534) + (b * .131);
			
			if( sepiar >= 255) {
				sepiar = 255;
			}
			if( sepiag >= 255) {
				sepiag = 255;
			}
			if( sepiab >= 255) {
				sepiab = 255;
			}
			raster[i] = (char) sepiar;
			raster[i +1] = (char)sepiag;
			raster[i + 2] = (char)sepiab;
		}
		
	}
	
	//creates a oddly colored image
	public void negative() {
		int r;
		int g;
		int b;
		for(int i = 0; i<raster.length; i+= 3) {
			r = (int)raster[i];
			g = (int)raster[i +1];
			b = (int)raster[i + 2];
			
			double negativer = 255 - r;
			double negativeg = 255 - g;
			double negativeb = 255 - b;
			
			if( negativer >= 255) {
				negativer = 255;
			}
			if( negativeg >= 255) {
				negativeg = 255;
			}
			if( negativeb >= 255) {
				negativeb = 255;
			}
			raster[i] = (char) negativer;
			raster[i +1] = (char)negativeg;
			raster[i + 2] = (char)negativeb;
		}
		
	}
		
	

}
