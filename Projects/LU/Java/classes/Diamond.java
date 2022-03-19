package classes;

import java.io.IOException;

public class Diamond extends Shapes {
	//This class extends the Shapes class and inherits all of it's instance variables

	//A construction method was not required to take any actions.	
    public Diamond(int row, int col) {
        super(row, col);
    }

	public void DiamondHelper()throws IOException{
		int sizeTwo = shapeArray[1].length;
		size = ((shapeArray.length + 1) / 2);
		GetUserChar();
		label = GetLabel(sizeTwo);
		labelRow = GetLine(labelRow, label.length(), size);
		InOut.ClearScreen();
		MakeATriangle(sizeTwo, sizeTwo, size, 4, shapeChar);
		AddTheLabel(label, labelRow, sizeTwo);
		PrintTheShape(sizeTwo, sizeTwo);	
	}

    public int GetLine(int line, int labelLen, int size)throws IOException{

		//This method does a similar function as in the other shape classes with the additional
		//computations for determining if the label will fit on a line in the bottom half of the 
		//diamond. 

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
			//will fit on any given line of the shape, and it expands the one for the triangle due to 
			//the bottom half of the shape being a mirror image of the top half.
            if (((line > 0) && (line <= size)) && 
            (((((topPoint + line) - (topPoint - line)) - 1) < labelLen) || 
            (((((line - 1) + topPoint) - (((line - 1) - topPoint) * 2)) - ((line - 1) - topPoint)) < labelLen))){
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

		//This method is very similar to the MakeATriangle method in the Triangle class.  It uses topPoint 
		//the same but has to do some additional calculations to get the correct array locations for the 
		//bottom part of the diamond.

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
