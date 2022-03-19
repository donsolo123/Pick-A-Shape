package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InOut {
	//There are no instance variables in this class.

	//The constructor method is also empty.
    public InOut(){
    }

    public static void ClearScreen(){

		//This method clears the screen using a simple System.out.println
		//statement due to it being the only way I could get it to work!!

		for (int looper = 0; looper <= 40; looper++){
			System.out.println();
		}
	}

    public void MainMenu(){

		//This method prints the main menu.

		System.out.println();
		System.out.println("Please choose from the below menu.");
		System.out.println("1 - Square");
		System.out.println("2 - Rectangle");
		System.out.println("3 - Triangle");
		System.out.println("4 - Diamond");
		System.out.println("5 - Circle");
		System.out.println("6 - Smiley");
		System.out.println("7 - Quit (for a special message)");
		System.out.println();
		System.out.print("Shape? ");
	}
	
	public static int GetUserInput(int userInput)throws IOException{

		//This method uses BufferedReader to recieve input from the keyboard.  It uses a try..catch 
		//statement because it is also attempting to parse out an integer from the inputed string. 
		//If the input was not numeric it loops and asks again for input.  If a number was parsed it 
		//then check to see if that number was valid, which is any number >= 0.
		//It checks to see if the enter key was pressed by looking at the length of the entered string,
		//where if the enter key was pressed the length would be 0.  The returned value is in the range
		//-2 to some positive number where a -1 means invalid input, and -2 is used by GetLine method to
		//indicate that the user is requesting the default label of "LU".

		BufferedReader readIn = new BufferedReader(new InputStreamReader (System.in));
		String userInputChr = null;
		userInput = -1;
		boolean flag = false;
		try{
			userInputChr = readIn.readLine();
			userInput = Integer.parseInt(userInputChr);
		}
		catch(NumberFormatException nfe){
			flag = true;
			int strLen = userInputChr.length();
			if (strLen == 0){
				userInput = -2;
			}
			else{
				userInput = -1;
			}
		}
		finally{
			if ((flag == false) && (userInput < 0)){
				userInput = -1;
			}
		}
        return userInput;
	}

    public int GetSize(int size, String messagePart)throws IOException{

		//This method returns the size of the shape the user has selected to draw.
		//The messagePart variable holds part of the message that is displayed
		//according to which shape was selected. It only allows a size in the range 
		//of 2 to 25 due to the limitations of trying to display a shape with ASCII 
		//characters either smaller of larger then the range.

		boolean endDo = false;
        System.out.println("Please enter the length of "+messagePart+": ");
		System.out.print("Please enter a value between 2 and 25 - ");
		do{
			size = GetUserInput(size);
			if ((size < 2) || (size > 25)){
				System.out.print("Invalid input, please try again!! - ");
			}
			else{
				System.out.println();
				endDo = true;
			}
		} while (endDo == false);
		return size;
	}
}
    

