public class TestArray2{
	public static void main(String[] args){
		int[] [] box=new int[10] [10];
		int row, col;
		for (row=0;row<10;row++){
			for (col=0;col<10;col++){
				box [row][col] = col;
			}
		}
		for (row=0;row<10;row++){
			for (col=0;col<10;col++){
				if (col==9){
					System.out.print(box[row][col]+"\n");
				}
				else {
					System.out.print(box[row][col]);
				}
			}
		}
	}
}