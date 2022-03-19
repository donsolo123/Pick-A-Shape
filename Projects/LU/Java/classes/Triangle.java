package classes;

import java.io.IOException;

public class Triangle extends Shapes{
	//This class extends the Shapes class and inherits all of it's instance variables

	//A construction method was not required to take any actions.
    public Triangle(int row, int col) {
        super(row, col);
    }

	public void TriangleHelper()throws IOException{
		int sizeTwo = 0;
		size = shapeArray.length;
		sizeTwo = shapeArray[1].length;
		GetUserChar();
		label = GetLabel(sizeTwo);
		labelRow = GetLine(labelRow, label.length(), size);
		InOut.ClearScreen();
		MakeATriangle(size, sizeTwo, size, 3, shapeChar);
		AddTheLabel(label, labelRow, sizeTwo);
		PrintTheShape(size, sizeTwo);	
	}
	
    public int GetLine(int line, int labelLen, int size)throws IOException{

		//This method returns the line of the shape where the user wants to place the label.
		//The method uses the GetUserInput method from the InOut class to recieve a valid input.
		//Then checks to see if the requested line is with the size of the shape, and then it checks
		//to determine if the shape is smaller then 6 lines and then sets the default line to something 
		//smaller then 4.  This method differs from Square or Rectangle in that it uses additional 
		//comparison opperations to determine where the egde of the shape is in relation to the bounds
		//of the array holding the shape.  topPoint holds the array location where to the point of the 
		//triangle is located, and then uses that starting point to compute how much room there is on each
		//line going down the triangle.  The number of "spaces" grows with each line.

		boolean endDo = false;
        int topPoint = 0;
		topPoint = (((size * 2) - 2) / 2);
		do{
			endDo = false;
			System.out.println("On what line would you like your Label? (press enter key for the default of 4)? ");
			System.out.print("The default size may be smaller then 4 depending on the size of the shape you have choosen ");
			line = ShapeIO.GetUserInput(line);
			System.out.println();
			if (line == -1){
				System.out.print("\n"+"Invalid input, please try again!! ");					
			}
			else{
				if ((line == 0) || (line > size)){
				System.out.print("\n"+"That Line is outside the bounds of the shape!! ");						
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
				}
			}

			//this statement uses topPoint as a reference point to determine if the label
			//will fit on any given line of the shape.
			if (((line > 0) && (line <= size)) && 
            ((((((topPoint + line) - (topPoint - line)) - 1) < labelLen)))){
				System.out.println("Your label will not fit on that line!!");
			}
			else{
				if (line <= 0){
					endDo = false;
				}
				else{
					endDo = true;
				}
			}
		}while (endDo == false);
		return line;
	}

    public char[][] MakeATriangle(int rowSize, int colSize, int oneSide, int whichShape, char shapeChar){

		//This method takes the character the user chose to make the shape and assigns the array elements
		//in the pattern for the triangle using the topPoint vaiable for a starting and refernece point to
		//be able to accurately draw the shape.

		int row, col, topPoint;
		topPoint = (((oneSide * 2) - 2) / 2);
		for (row = 0; row < rowSize; row++){
			for (col = 0; col < colSize; col++){
				if ((row == 0) && (col == topPoint)){
					shapeArray [row][col] = shapeChar;					
				}
				else{
					if ((col == topPoint - row) || 
                    ((col == topPoint + row) || ((row == rowSize - 1) && (whichShape == 3)))){
						shapeArray [row][col] = shapeChar;	
					}
					else {
						if((col == row - topPoint) || 
                        (col == ((row + topPoint) - ((row - topPoint) * 2)))){
							shapeArray [row][col] = shapeChar;	
						}							
						else {
							shapeArray[row][col] = ' ';
						}
					}
				}
			}
		}
		return shapeArray;	
	}
}
