import java.util.*;
import java.util.Scanner;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class PickAShape{
	public static void main(String[] args)throws IOException{
		int choice = 0, size = 0, LabelRow = 0;
		StringBuilder Label = new StringBuilder(25);
		BufferedReader ReadIn = new BufferedReader(new InputStreamReader (System.in));
		
		ClearScreen();
		System.out.println("Welcome to The Shape Selector!! The home of all your best shapes!");
		do{
			PrintMainMenu();
			choice = GetUserInput(choice);
			if ((choice >= 1) && (choice <= 7)){
				switch(choice){
					case 1:
						int Size1 = 0;
						Size1 = GetSize(Size1, choice, 0);
						char[][] Square = new char[Size1][Size1];
						GetLabel(Label, Size1);
						LabelRow = GetLine(LabelRow, Label.length(), Size1, choice);
						ClearScreen();
						MakeASquare(Square, Size1, Size1);
						AddTheLabel(Square, Label, LabelRow, Size1);
						PrintTheShape(Square, Size1, Size1);
					break;
					case 2:
						int Size2 = 0, RecRow = 0, RecCol = 0;
						Size2 = GetSize(Size2, choice, 1);
						RecRow = Size2;
						Size2 = GetSize(Size2, choice, 2);
						RecCol = Size2;	
						char[][] Rectangle = new char[RecRow][RecCol];
						GetLabel(Label, RecCol);
						LabelRow = GetLine(LabelRow, Label.length(), RecRow, choice);
						ClearScreen();						
						MakeASquare(Rectangle, RecRow, RecCol);
						AddTheLabel(Rectangle, Label, LabelRow, RecCol);
						PrintTheShape(Rectangle, RecRow, RecCol);				
					break;
					case 3:
						int Size3 = 0, TriCol = 0;
						Size3 = GetSize(Size3, choice, 0);
						TriCol = (Size3 * 2) - 1;
						char[][] Triangle = new char[Size3][TriCol];
						GetLabel(Label, TriCol);
						LabelRow = GetLine(LabelRow, Label.length(), Size3, choice);
						ClearScreen();
						MakeATriangle(Triangle, Size3, TriCol, Size3, choice);
						AddTheLabel(Triangle, Label, LabelRow, TriCol);
						PrintTheShape(Triangle, Size3, TriCol);	
					break;
					case 4:
						int Size4 = 0, DiaSize = 0;
						Size4 = GetSize(Size4, choice, 0);
						DiaSize = (Size4 * 2) - 1;
						char[][] Diamond = new char[DiaSize][DiaSize];
						GetLabel(Label, DiaSize);
						LabelRow = GetLine(LabelRow, Label.length(), Size4, choice);
						ClearScreen();
						MakeATriangle(Diamond, DiaSize, DiaSize, Size4, choice);
						AddTheLabel(Diamond, Label, LabelRow, DiaSize);
						PrintTheShape(Diamond, DiaSize, DiaSize);	
					break;
					case 5:
						int Size5 = 0, CirSize = 0;
						Size5 = GetSize(Size5, choice, 0);
						CirSize = (Size5 * 2) + 1;
						char[][] Circle = new char[CirSize][CirSize];
						GetLabel(Label, CirSize);
						LabelRow = GetLine(LabelRow, Label.length(), Size5, choice);
						ClearScreen();
						MakeACircle(Circle, Size5);
						AddTheLabel(Circle, Label, LabelRow, CirSize);
						PrintTheShape(Circle, CirSize, CirSize);	
					break;
					case 6:
						int Size6 = 0, SmileSize = 0;
						Size6 = GetSize(Size6, choice, 0);
						SmileSize = (Size6 * 2) + 1;
						char[][] Face = new char[SmileSize][SmileSize];
						ClearScreen();
						MakeACircle(Face, Size6);
						MakeASmile(Face, Size6);
						MakeAnEye(Face, Size6);
						PrintTheShape(Face, SmileSize, SmileSize);	
					break;				
					case 7:
						System.out.println("It has been a pleasure making shapes with you today!!!");
						System.out.print("Good Bye, and have a NICE day!!!");
					break;
				}
			}
			else{
				System.out.println("You did not make a choice, please try again!!!");
			}
		} while (choice != 7);

	}
	
	private static void PrintMainMenu(){
		System.out.println();
		System.out.println("Please choose from the below menu.");
		System.out.println("1 - Square");
		System.out.println("2 - Rectangle");
		System.out.println("3 - Triangle");
		System.out.println("4 - Diamond");
		System.out.println("5 - Circle");
		System.out.println("6 - Smiley");
		System.out.println("7 - Quit");
				System.out.println();
		System.out.print("Shape? ");		
	}
	
	public static int GetSize(int size, int ShapeMsg, int MsgFlag)throws IOException{
		int endDo = 0;
		switch(ShapeMsg){
			case 1:
				System.out.println("Please enter the length of one side of the square.");
			break;
			case 2:
				if (MsgFlag == 1){
					System.out.println("Please enter the length of side one for the rectangle: ");
				}
				else{
					if (MsgFlag == 2){
						System.out.println("Please enter the length of side two for the rectangle: ");
					}
				}
			break;
			case 3:
				System.out.println("Please enter one side of the triangle: ");
			break;
			case 4:
				System.out.println("Please enter one side of the diamond: ");
			break;
			case 5:
				System.out.println("Please enter the radius of the circle: ");
			break;
			case 6:
				System.out.println("Please enter the radius of the smiley face: ");
			break;
		}
		System.out.print("Please enter a value between 2 and 25 - ");
		do{
			size = GetUserInput(size);
			if ((size < 2) || (size > 25)){
				System.out.print("Invalid input, please try again!! - ");
			}
			else{
				System.out.println();
				endDo = 1;
			}
		} while (endDo == 0);
		return size;
	}
	
	private static void ClearScreen(){
		int looper;
		for (looper = 0; looper <= 40; looper++){
			System.out.println();
		}
	}
		
	private static int GetUserInput(int UserInput)throws IOException{
		BufferedReader ReadIn = new BufferedReader(new InputStreamReader (System.in));
		String UserInputChr = null;
		UserInput = -1;
		int flag = 0;
		try{
			UserInputChr = ReadIn.readLine();
			UserInput = Integer.parseInt(UserInputChr);
		}
		catch(NumberFormatException nfe){
			flag = 1;
			int strLen = UserInputChr.length();
			if (strLen == 0){
				UserInput = -2;
			}
			else{
				UserInput = -1;
			}
		}
		finally{
			if ((flag == 0) && (UserInput < 0)){
				UserInput = -1;
				return UserInput;
			}
			else{
				return UserInput;
			}
		}
	}
	
	private static void GetLabel(StringBuilder Label, int col)throws IOException{
		Scanner ReadIn = new Scanner(System.in);		
		int strLenLabel = Label.length();
		int strLenNewLabel;
		StringBuffer NewLabel = new StringBuffer();
		Label = Label.delete(0,strLenLabel);
		do{
			System.out.print("Type your label here or hit enter for the default of LU? " );		
			NewLabel.append(ReadIn.nextLine());
			System.out.println();
			strLenNewLabel = NewLabel.length();
			if (strLenNewLabel > col){
				System.out.println("Sorry your label is bigger then your shape!!"+"\n");
				NewLabel = NewLabel.delete(0,strLenNewLabel);				
			}
		}while (strLenNewLabel > col);
		if (strLenNewLabel != 0){
			Label.append(NewLabel);
		}
		else{
			Label.append("LU");
		}
	}
	
	private static int GetLine(int Line, int LabelLen, int Size, int Case)throws IOException{
		int endDo = 0, TopPoint = 0, cirLineLen = 0, col;
		int rowsize = (Size * 2) + 1;
		int colsize = (Size * 2) + 1;
		double distance = 0.0, distanceMax = 0.0;
		TopPoint = (((Size * 2) - 2) / 2);
		if (Case == 4){
			Size = (Size * 2) - 1;
		}
		else {
			if ((Case == 5) || (Case == 6)){
				distanceMax = (Size + .3);
			}
		}
		do{
			endDo = 0;
			System.out.print("On what line would you like your Label? (press enter key for the default of 4)? ");	
			Line = GetUserInput(Line);
			System.out.println();
			if (Line == -1){
				System.out.println("Invalid input, please try again!!");					
			}
			else{
				if ((Line == 0) || (((Case != 5) || (Case != 6)) && (Line > Size)) || 
				(((Case == 5) || (Case == 6)) && (Line > rowsize))){
					System.out.println("That Line is outside the bounds of the shape!!");						
				}
				else{
					if (Line == -2){
						if ((Case == 5) || (Case == 6)){
							if ((rowsize == 2) || (rowsize == 3)){
								Line = 2;
							}
							else{
								if ((rowsize == 4) || (rowsize == 5)){
									Line = 3;
									
								}
								else{
									Line = 4;
								}
							}
						}
						else{
							if ((Size == 2) || (Size == 3)){
								Line = 2;
							}
							else {
								if ((Size == 4) || (Size == 5)){
									Line = 3;
								}
								else{
									Line = 4;
								}
							}
						}
					}
				}
			}
			if (((Line > 0) && (Line <= Size)) && ((Case == 3) && (((((TopPoint + Line) - (TopPoint - Line)) - 1) < LabelLen)))){
				System.out.println("Your label will not fit on that line!!");
			}
			else{
				if (((Line > 0) && (Line <= Size)) && ((Case == 4) && (((((((TopPoint + Line) - (TopPoint - Line)) - 1) < LabelLen) || 
				(((((Line - 1) + TopPoint) - (((Line - 1) - TopPoint) * 2)) - ((Line - 1) - TopPoint)) < LabelLen)))))){
				System.out.println("Your label will not fit on that line!!");
				}
				else{
					if ((Line > 0) && ((Case == 5) || (Case == 6))){
						cirLineLen = 0;
						for (col = 0; col <= colsize; col++){
							distance = Math.sqrt((Math.pow((Line - 1) - Size, 2)) + (Math.pow(col - Size, 2)));
							if (distance < distanceMax){
								cirLineLen++;
							}
						}
						if (cirLineLen < LabelLen){
							System.out.println("Your label will not fit on that line!!");
						}
						else{
							endDo = 1;
						}
					}
					else{
						if (Line <= 0){
							endDo = 0;
						}
						else{
							endDo = 1;
						}
					}
				}
			}
		}while (endDo == 0);
		return Line;
	}
	
	private static int GetNumber(int max, int min){
        int range = max - min + 1;
        int random = (int)(Math.random() * range) + min;
		return random;
	}
	
	private static void PrintTheShape(char[][] shape, int rowsize, int colsize){
		int row, col;
		String Xpoint;
		for (row = 0; row < rowsize; row++){
			for (col = 0; col < colsize; col++){
				if (col == colsize-1){
					System.out.print(shape[row][col]+" "+"\n");
				}
				else {
					System.out.print(shape[row][col]+" ");
				}
			}
		}		
	}
	
	private static char[][] AddTheLabel(char[][] TheShape, StringBuilder Label, int LabelRow, int colsize){
		int row = LabelRow - 1, col = 0, looper =0;
		int LabelCol = ((colsize - (Label.length())) / 2);
		for (col = 0; col < colsize; col++){
			if ((col >= LabelCol) && (col <= (LabelCol + Label.length()-1))){
				TheShape[row][col] = Label.charAt(looper);
				looper++;
			}
		}
		return TheShape;
	}
	
	private static char[][] MakeASquare(char[][] Shape, int rowsize, int colsize){
		int row, col;
		for (row = 0; row < rowsize; row++){
			for (col = 0; col < colsize; col++){
				if ((row == 0) || (row == rowsize-1)){
					Shape [row][col] = 'X';
				}
				else{
					if ((col == 0) || (col == colsize-1)){
						Shape[row][col] = 'X';
					}
					else{
						Shape[row][col] = ' ';
					}
				}
			}
		}
		return Shape;
	}
	
	private static char[][] MakeATriangle(char[][] Shape, int rowsize, int colsize, int OneSide, int Case){
		int row, col, TopPoint;
		TopPoint = (((OneSide * 2) - 2) / 2);
		for (row = 0; row < rowsize; row++){
			for (col = 0; col < colsize; col++){
				if ((row == 0) && (col == TopPoint)){
					Shape [row][col] = 'X';					
				}
				else{
					if ((col == TopPoint - row) || (col == TopPoint + row || ((row == rowsize - 1) && (Case == 3)))){
						Shape [row][col] = 'X';	
					}
					else {
						if((col == row - TopPoint) || (col == ((row + TopPoint) - ((row - TopPoint) * 2)))){
							Shape [row][col] = 'X';	
						}							
						else {
						Shape[row][col] = ' ';
						}
					}
				}
			}
		}
		return Shape;	
	}
	
	private static char[][] MakeACircle(char[][] circle, int radius){
		int row, col;
		int rowsize = (radius * 2) + 1;
		int colsize = (radius * 2) + 1;
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
			if (((row >= 0) && (row <= (rowsize))) && ((col >= 0) && (col <= (colsize))) && (distance < distanceMax)){
				circle[row][col] = 'X';
			}
		}
		return circle;
	}
	
	private static char[][] MakeASmile(char[][] face, int radius){
		int mouthRow, mouthCol, mouthLoop, mouthRadius, mouthRowLoop, mouthColLoop;
		int faceRow, faceCol, faceRowLoop, faceColLoop;
		mouthRadius = radius - 2;
		mouthRow = (mouthRadius * 2) + 1;
		mouthCol = (mouthRadius * 2) + 1;
		faceRow = (radius * 2) + 1;
		faceCol = (radius * 2) + 1;
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
		MakeACircle(mouth, mouthRadius);
		for (mouthRowLoop = mouthLoop; mouthRowLoop < mouthRow; mouthRowLoop++){
			for (mouthColLoop = 0; mouthColLoop < mouthCol; mouthColLoop++){
				if (mouth[mouthRowLoop][mouthColLoop] == 'X'){
					face[faceRowLoop][faceColLoop] = 'X';
					faceColLoop++;
				}
				else{
					faceColLoop++;
				}
			}
			faceRowLoop++;
			faceColLoop = 2;
		}
		return face;
	}
	
	private static char[][] MakeAnEye(char[][] face, int radius){
		int eyeRow, eyeCol, eyeLoop, eyesize = 0, eyeRowLoop, eyeColLoop;
		int faceRow, faceCol, faceRowLoop = 0, faceColLoop = 0, faceColLoopSave = 0;
		int leftEyeLoop = 1;
		faceRowLoop = radius - (radius / 2);
		faceColLoop = radius - (radius / 2);
		faceColLoopSave = faceColLoop;
		eyesize = radius / 2;
		char[][] eye = new char[eyesize][eyesize];
		MakeASquare(eye, eyesize, eyesize);
		for (eyeRowLoop = 0; eyeRowLoop < eyesize; eyeRowLoop++){
			for (eyeColLoop = 0; eyeColLoop < eyesize; eyeColLoop++){
				if (eye[eyeRowLoop][eyeColLoop] == 'X'){
					face[faceRowLoop][faceColLoop] = 'X';
					face[faceRowLoop][radius + leftEyeLoop] = 'X';
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
		
		return face;
	}
}
