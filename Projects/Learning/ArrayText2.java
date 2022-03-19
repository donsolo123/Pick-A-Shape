import java.util.Scanner;
public class ArrayText2{
	public static void main(String args[]){
		int row, col, size, rowsize, colsize;
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please enter the length of one side of the box: ");
		size = scanner.nextInt();
		rowsize = size;
		colsize = size;
		String[][] box=new String[rowsize][colsize];
		for (row=0;row<rowsize;row++){
			for (col=0;col<colsize;col++){
				if ((row==0) || (row==rowsize-1)){
					box [row][col] = "X";
				}
				else{
					if ((col==0) || (col==colsize-1)){
						box[row][col] = "X";
					}
					else{
						box[row][col] = " ";
					}
				}

			}
		}
	box[(rowsize/2)][(colsize/2)-1] = "L";
	box[(rowsize/2)][(colsize/2)+1] = "U";	
		for (row=0;row<rowsize;row++){
			for (col=0;col<colsize;col++){
				if (col==colsize-1){
					System.out.print(box[row][col]+"\n");
				}
				else {
					System.out.print(box[row][col]);
				}
			}
		}
	}
}