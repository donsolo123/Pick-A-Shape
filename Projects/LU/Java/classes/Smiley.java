package classes;

import java.io.IOException;

public class Smiley extends Shapes{
	//This class extends the Shapes class and inherits all of it's instance variables

	//A construction method was not required to take any actions.	
    public Smiley(int row, int col) {
        super(row, col);
    }

	public void SmileyHelper()throws IOException{
		int sizeTwo = shapeArray.length;
		size = ((shapeArray.length - 1) / 2);
		GetUserChar();
		InOut.ClearScreen();
		SmileyCon(size);
		MakeASmile(size);
		MakeAnEye(size);
		PrintTheShape(sizeTwo, sizeTwo);	
	}

    public int GetLine(int line, int labelLen, int size)throws IOException{

		//This method is very similar to the others like it, except it also must use the distance 
		//computations from finding points of a circle using radians in order to determine where the 
		//edges of the shape are in the array.  It returns the line of the shape where the 
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

	public char[][] SmileyCon(int radius){

		//In order for the construction of the smiley face it was neccessary to 
		//preserve the shapeArray because two other arrays are used in the making
		//of the face.

		shapeArray = MakeACircle(radius);
		return shapeArray;
	}

    public char[][] MakeACircle(int radius){

		//This is the same as in the Circle class but it was also neccessary to return a
		//different array then shapeArray due to the need of preserving ShapeArray.

		int row, col;
		int rowSize = (radius * 2) + 1;
		int colSize = (radius * 2) + 1;
		double looper,  angle, xLoc, yLoc, distance;
		double distanceMax = (radius + .3);
		char[][] cirShapeArray = new char[rowSize][colSize];
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
				cirShapeArray[row][col] = shapeChar;
			}
		}
		return cirShapeArray;
	}

    public char[][] MakeASmile(int radius){

		//This method uses an additional array that is used to compute another circle using 
		//the MakeACircle method which is then used to form the mouth.  The array locations are
		//duplicated from the mouth array to the face array.

		int mouthRow, mouthCol, mouthLoop, mouthRadius, mouthRowLoop, mouthColLoop;
		int faceRow, faceRowLoop, faceColLoop;
		mouthRadius = radius - 2;
		mouthRow = (mouthRadius * 2) + 1;
		mouthCol = (mouthRadius * 2) + 1;
		faceRow = (radius * 2) + 1;
		if(radius == 2){
			faceRowLoop = faceRow - 3;
			mouthLoop = mouthRow;
		}
		else{
			if(radius == 3){
				faceRowLoop = faceRow - 3;
				mouthLoop = mouthRow - 2;
			}
			else{
				if(radius == 4){
					faceRowLoop = faceRow - 4;
					mouthLoop = mouthRow - 2;			
				}
				else{
					if (radius < 9){
						faceRowLoop = faceRow - 5;
						mouthLoop = mouthRow - 3;
					}	
					else{
						faceRowLoop = faceRow - 7;
						mouthLoop = mouthRow - 4;
					}
				}
			}
		}
		faceColLoop = 2;
		char[][] mouth = new char[mouthRow][mouthCol];
		mouth = null;
		mouth = MakeACircle(mouthRadius);
		for (mouthRowLoop = mouthLoop; mouthRowLoop < mouthRow; mouthRowLoop++){
			for (mouthColLoop = 0; mouthColLoop < mouthCol; mouthColLoop++){
				if (mouth[mouthRowLoop][mouthColLoop] == shapeChar){
					shapeArray[faceRowLoop][faceColLoop] = shapeChar;
					faceColLoop++;
				}
				else{
					faceColLoop++;
				}
			}
			faceRowLoop++;
			faceColLoop = 2;
		}
		return shapeArray;
	}
	
	public char[][] MakeAnEye(int radius){

		//This method uses the same method as the square to form an eye and then
		//by using the one array places the second eye based off the first eye and 
		//therefore places both eyes almost simultaneouly.

		int eyeSize = 0, eyeRowLoop, eyeColLoop;
		int faceRowLoop = 0, faceColLoop = 0, faceColLoopSave = 0;
		int leftEyeLoop = 1;
		faceRowLoop = radius - (radius / 2);
		faceColLoop = radius - (radius / 2);
		faceColLoopSave = faceColLoop;
		eyeSize = radius / 2;
		char[][] eye = new char[eyeSize][eyeSize];
		eye = MakeASquare(eyeSize, eyeSize);
		for (eyeRowLoop = 0; eyeRowLoop < eyeSize; eyeRowLoop++){
			for (eyeColLoop = 0; eyeColLoop < eyeSize; eyeColLoop++){
				if (eye[eyeRowLoop][eyeColLoop] == shapeChar){
					shapeArray[faceRowLoop][faceColLoop] = shapeChar;
					shapeArray[faceRowLoop][radius + leftEyeLoop] = shapeChar;
					leftEyeLoop++;
					faceColLoop++;
				}
				else{
					faceColLoop++;
					leftEyeLoop++;
				}
			}
			faceRowLoop++;
			faceColLoop = faceColLoopSave;
			leftEyeLoop = 1;
		}		
		return shapeArray;
	}

	public char[][] MakeASquare(int rowSize, int colSize){

		//This is the same method used to make a square except that another
		//array has been defined to hold the eye shape in order to preserve
		//the shapeArray which hold the smiley face.

		int row, col;
		char[][] squareShapeArray = new char[rowSize][colSize];
		for (row = 0; row < rowSize; row++){
			for (col = 0; col < colSize; col++){
				if ((row == 0) || (row == rowSize-1)){
					squareShapeArray [row][col] = shapeChar;
				}
				else{
					if ((col == 0) || (col == colSize-1)){
						squareShapeArray[row][col] = shapeChar;
					}
					else{
						squareShapeArray[row][col] = ' ';
					}
				}
			}
		}
		return squareShapeArray;
	}    
}
