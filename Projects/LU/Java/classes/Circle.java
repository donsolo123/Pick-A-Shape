package classes;

import java.io.IOException;

public class Circle extends Shapes {
	//This class extends the Shapes class and inherits all of it's instance variables

	//A construction method was not required to take any actions.	
    public Circle(int row, int col) {
        super(row, col);
    }

	public void CircleHelper()throws IOException{
		int sizeTwo = shapeArray.length;
		size = ((shapeArray.length - 1) / 2);
		GetUserChar();
		label = GetLabel(sizeTwo);
		labelRow = GetLine(labelRow, label.length(), size);
		InOut.ClearScreen();
		MakeACircle(size);
		AddTheLabel(label, labelRow, sizeTwo);
		PrintTheShape(sizeTwo, sizeTwo);	
	}
    
	public int GetLine(int line, int labelLen, int size)throws IOException{

		//This method is very similar to the others like it.  It returns the line of the shape where the 
		//user wants to place the label. The method uses the GetUserInput method from the InOut class 
		//to recieve a valid input.  Then checks to see if the requested line is with the size of the 
		//shape, and then it checks  to determine if the shape is smaller then 6 lines and then sets 
		//the default line to something smaller then 4.

		boolean endDo = false; 
        int cirLineLen = 0, col;
		int rowSize = (size * 2) + 1;
		int colSize = (size * 2) + 1;
		double distance = 0.0, distanceMax = 0.0;
		distanceMax = (size + .3);
		do{
			System.out.println("On what line would you like your Label? (press enter key for the default of 4)? ");
			System.out.print("The default size may be smaller then 4 depending on the size of the shape you have choosen ");
			line = ShapeIO.GetUserInput(line);
			System.out.println();
			if (line == -1){
				System.out.print("\n"+"Invalid input, please try again!! ");				
			}
			else{
				if ((line == 0) || (line > rowSize)){
					System.out.println("That Line is outside the bounds of the shape!!");						
				}
				else{
					if (line == -2){
						if ((rowSize == 2) || (rowSize == 3)){
							line = 2;
						}
						else{
							if ((rowSize == 4) || (rowSize == 5)){
								line = 3;
							}
							else{
								line = 4;
							}
						}
					}
				}
            }
			if (line > 0){
				cirLineLen = 0;
                 for (col = 0; col <= colSize; col++){
					distance = Math.sqrt((Math.pow((line - 1) - size, 2)) + (Math.pow(col - size, 2)));
					if (distance < distanceMax){
						cirLineLen++;
					}
				}
				if (cirLineLen < labelLen){
					System.out.println("Your label will not fit on that line!!");
				}
				else{
					endDo = true;
				}
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

    public char[][] MakeACircle(int radius){

		//This method draws the circle using radians and then uses the distance from the center
		//point as a guide as to if the array element at the correspoding position should be a blank
		//or the chosen user character.

		int row, col;
		int rowSize = (radius * 2) + 1;
		int colSize = (radius * 2) + 1;
		double looper,  angle, xLoc, yLoc, distance;
		double distanceMax = (radius + .3);
		for (looper = 0; looper < 360; looper = looper + 1){
			angle = looper;
			xLoc = radius * (Math.cos((angle * Math.PI) / 180)) + radius;
			yLoc = radius * (Math.sin((angle * Math.PI) / 180)) + radius;
			xLoc = Math.round(xLoc);
			yLoc = Math.round(yLoc);
			row = (int)xLoc;
			col = (int)yLoc;
			distance = Math.sqrt((Math.pow(row - radius, 2)) + (Math.pow(col - radius, 2)));
			if (((row >= 0) && (row <= (rowSize))) && 
            ((col >= 0) && (col <= (colSize))) && (distance < distanceMax)){
				shapeArray[row][col] = shapeChar;
			}
		}
		return shapeArray;
	}
}
