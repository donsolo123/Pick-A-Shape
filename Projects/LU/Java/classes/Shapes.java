package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shapes{
	//instance variables
	int row = 0, col = 0, size = 0, labelRow = 0;
	char[][] shapeArray;
	char shapeChar;
	StringBuilder label = new StringBuilder(25);

	//constructor method for class Shapes
	public Shapes(int rowSize, int colSize){
		shapeArray = new char [rowSize][colSize];
	}

	public void PrintTheShape(int rowSize, int colSize){

		//This method prints the shape to the screen.

		for (row = 0; row < rowSize; row++){
			for (col = 0; col < colSize; col++){
				if (col == colSize-1){
					System.out.print(shapeArray[row][col]+" "+"\n");
				}
				else {
					System.out.print(shapeArray[row][col]+" ");
				}
			}
		}		
	}

	public char[][] AddTheLabel(StringBuilder label, int labelRow, int colSize){

		//This method takes the label that the user had entered and the line of the shape
		//they want it on and places the label into the char array that is used to build the shape.
		//This method is called just before the method above that prints the shape.	

		int labelLine = labelRow - 1, looper =0;
		int labelCol = ((colSize - (label.length())) / 2);
		for (col = 0; col < colSize; col++){
			if ((col >= labelCol) && (col <= (labelCol + label.length()-1))){
				shapeArray[labelLine][col] = label.charAt(looper);
				looper++;
			}
		}
		return shapeArray;
	}

	public void GetUserChar()throws IOException{

		//This method uses the global class variables and asks the user which character 
		//they would like to use to print the shape to the screen.  It uses StringBuffer to read 
		//in the keyboard input then parses out the first character in the string and makes that
		//the character to use to make shape.

		BufferedReader readIn = new BufferedReader(new InputStreamReader (System.in));	
		StringBuffer newChar = new StringBuffer();
		boolean endDo = false;
		System.out.print("What character would you like me to use to print the shapes with (press enter for the default of 'X')? ");	
		do{
			newChar.append(readIn.readLine());
			if(newChar.length() != 0){
				shapeChar = newChar.charAt(0);
				System.out.println("I will use "+shapeChar+" to print your shape.");
				endDo = true;
			}
			else{
				if(newChar.length() == 0){
					shapeChar = 'X';
					endDo = true;
				}
			}
		}while (endDo == false);
		//return shapeChar;
	}

	public StringBuilder GetLabel(int colSize)throws IOException{

		//This method uses StringBuffer again to read input from the keyboard. Then it gets the 
		//length of the string entered and compares to the passed in value which is the size of 
		//shape.  If the length of the label is larger then the size of the shape another request 
		//is made to input a label.

		BufferedReader readIn = new BufferedReader(new InputStreamReader (System.in));	
		int strLenLabel = label.length();
		int strLenNewLabel;
		String Zstring;
		StringBuffer newLabel = new StringBuffer();
		label = label.delete(0,strLenLabel);
		System.out.print("Type your label here or hit enter for the default of LU? ");	
		do{
			newLabel.append(readIn.readLine());
			strLenNewLabel = newLabel.length();
			if (strLenNewLabel > colSize){
				System.out.print("\n"+"Sorry your label is bigger then your shape, Please try again. ");
				newLabel = newLabel.delete(0,strLenNewLabel);				
			}
		}while (strLenNewLabel > colSize);
		Zstring = newLabel.toString();
		System.out.println(Zstring);
		if (Zstring == "Zelda"){
			System.out.println("hello!!!!");
			MakeZelda();
		}
		if (strLenNewLabel != 0){
			label.append(newLabel);
		}
		else{
			label.append("LU");
		}
		return label;
	}

	public void MakeZelda(){

		//This is an Easter Egg.
	
		Triangle zelda = new Triangle(25, 49);
		boolean placeX = false;
		char[] message = new char[] {'T','h','e','L','e','g','e','n','d','o','f','Z','e','l','d','a'};
		//System.out.println("I am in the zelda method!!");
		shapeArray = zelda.MakeATriangle(25, 49, 25, 3, 'X');
		//PrintTheShape(25, 49);
		for (int row = 1; row < 24; row++){
			 for (int col = 0; col < 49; col++){
				if ((shapeArray[row][col] == ' ') && (placeX == true)){
					shapeArray[row][col] = 'X';
				}
				else{
					if (shapeArray[row][col] == 'X'){
						if (placeX == false){
							placeX = true;
						}
						else{
							placeX = false;
						}
					}		
				}
			}
		}
		int leftCol = 12, rightCol = 36, messagePos = 0;
		for (row = 13; row <= 24; row++){
			leftCol++;
			rightCol--;
			for (col = leftCol; col < rightCol; col++){
				switch (row){
					case 14:
						if ((col >= 22) && (col <= 24)){
							shapeArray[row][col] = message[messagePos];
							messagePos++;
							placeX = false;
						}
					break;
					case 16:
						if ((col >= 21) && (col <= 26)){
							shapeArray[row][col] = message[messagePos];
							messagePos++;
							placeX = false;
						}
					break;
					case 18:
						if ((col >= 23) && (col <= 24)){
							shapeArray[row][col] = message[messagePos];
							messagePos++;
							placeX = false;
						}
					break;
					case 20:
						if ((col >= 21) && (col <= 25)){
							shapeArray[row][col] = message[messagePos];
							messagePos++;
							placeX = false;
						}
					break;
				}
				if (placeX == true){
					shapeArray[row][col] = ' ';
				}
				else{
					placeX = true;
				}
				
				
			}
		}
		PrintTheShape(25, 49);	
	}	
}
