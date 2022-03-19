package classes;

import java.io.IOException;

public class Rectangle extends Shapes {
	//This class extends the Shapes class and inherits all of it's instance variables

	//A construction method was not required to take any actions.
    public Rectangle(int row, int col) {
		super(row, col);
	}

	public void RectangleHelper() throws IOException{
		int row = 0, col = 0;
		row = shapeArray.length;
		col = shapeArray[1].length;
		GetUserChar();
		label = GetLabel(col);
		labelRow = GetLine(labelRow, label.length(), row);
		InOut.ClearScreen();						
		MakeASquare(row, col);
		AddTheLabel(label, labelRow, col);
		PrintTheShape(row, col);
	}
    
    public int GetLine(int line, int labelLen, int size)throws IOException{

		//This method returns the line of the shape where the user wants to place the label.
		//The method uses the GetUserInput method from the InOut class to recieve a valid input.
		//Then checks to see if the requested line is with the size of the shape, and then it checks
		//to determine if the shape is smaller then 6 lines and then sets the default line to something 
		//smaller then 4.

		boolean endDo = false;
		int rowsize = (size * 2) + 1;
		System.out.println("On what line would you like your Label? (press enter key for the default of 4)? ");
		System.out.print("The default size may be smaller then 4 depending on the size of the shape you have choosen ");
		do{
			line = ShapeIO.GetUserInput(line);
			if (line == -1){
				System.out.print("\n"+"Invalid input, please try again!! ");
			}
			else{
				if ((line == 0) || (line > rowsize)){
					System.out.print("That Line is outside the bounds of the shape!! ");						
				}
				else{
					if (line == -2){
						if ((size == 2) || (size == 3)){
								line = 2;
						}
						else {
							if ((size == 4) || (size == 5)){
								line = 3;
							}
							else{
								line = 4;
							}
						}			
					}
					endDo = true;
				}				
			}
		}while (endDo == false);
		return line;
	}

    public char[][] MakeASquare(int rowsize, int colsize){

		//This method assigns the character that the user chose to print the 
		//shapes with to the array in the selected shape.  The array variable
		//used is the global one found in the Shapes class.

		int row, col;
		for (row = 0; row < rowsize; row++){
			for (col = 0; col < colsize; col++){
				if ((row == 0) || (row == rowsize-1)){
					shapeArray [row][col] = shapeChar;
				}
				else{
					if ((col == 0) || (col == colsize-1)){
						shapeArray[row][col] = shapeChar;
					}
					else{
						shapeArray[row][col] = ' ';
					}
				}
			}
		}
		return shapeArray;
	}
}
