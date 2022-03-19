import classes.*;
import java.io.IOException;

public class OOPPickAShape{
	/*
		This is the main class and where program execution happens 
	*/
	
	public static void main(String[] args)throws IOException{
		//Create an instance of InOut.class.
		InOut ShapeIO = new InOut();

		//variable declaration and initilization
		int choice = 0,size = 0, sizeTwo = 0;

		//main program begin
		InOut.ClearScreen();
		System.out.println("Welcome to The Shape Selector!! The home of all your best shapes!");		
		do{		//loop until a 7 is selected at the main menu
			ShapeIO.MainMenu();
			choice = InOut.GetUserInput(choice);
			if ((choice >= 1) && (choice <= 7)){
				switch(choice){
					case 1:		//make a square
						size = ShapeIO.GetSize(size, "one side of the square");
						Square s = new Square(size, size);
						s.SquareHelper();
					break;
					case 2:		//make a rectangle
						int rectRow = 0, rectCol = 0;
						rectRow = ShapeIO.GetSize(size, "side one of the rectangle");
						rectCol = ShapeIO.GetSize(size, "side two of the rectangle");
						Rectangle r = new Rectangle(rectRow, rectCol);
						r.RectangleHelper();
					break;
					case 3:		//make a triangle
						size = ShapeIO.GetSize(size, "one side of the triangle");
						sizeTwo = (size * 2) - 1;
						Triangle t = new Triangle(size, sizeTwo);
						t.TriangleHelper();
					break;
					case 4:		//make a diamond
						size = ShapeIO.GetSize(size, "one side of the diamond");
						sizeTwo = (size * 2) - 1;
						Diamond d = new Diamond(sizeTwo, sizeTwo);
						d.DiamondHelper();
					break;
					case 5:		//make a circle
						size = ShapeIO.GetSize(size, "the radius of the circle");
						sizeTwo = (size * 2) + 1;
						Circle c = new Circle(sizeTwo, sizeTwo);
						c.CircleHelper();
					break;
					case 6:		//make a smiiley face
						size = ShapeIO.GetSize(size, "the radius of the smiley face");
						sizeTwo = (size * 2) + 1;
						Smiley smile = new Smiley(sizeTwo, sizeTwo);
						smile.SmileyHelper();
					break;				
					case 7:		//say good bye and exit
						Triangle z = new Triangle(25, 49);
						z.MakeZelda();
						System.out.println("It has been a pleasure making shapes with you today!!!");
						System.out.print("Good Bye, and have a NICE day!!!");
					break;
				}
			}
			else{
				System.out.println("You did not make a choice, please try again!!!");
			}
		}while (choice != 7);
	}
}