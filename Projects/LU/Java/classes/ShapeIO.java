package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapeIO {

    public ShapeIO(){
    }

    public void ClearScreen(){
		for (int looper = 0; looper <= 40; looper++){
			System.out.println();
		}
	}

    public void MainMenu(){
		System.out.println();
		System.out.println("Please choose from the below menu.");
		System.out.println("1 - Square");
		System.out.println("2 - Rectangle");
		System.out.println("3 - Triangle");
		System.out.println("4 - Diamond");
		System.out.println("5 - Circle");
		System.out.println("6 - Smiley");
		System.out.println("7 - Random?");
		System.out.println();
		System.out.print("Shape? ");
	}
	
	public static int GetUserInput(int userInput)throws IOException{
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
    

