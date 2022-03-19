public class TestArray {
	public static void main(String[] args) {
		int[] x=new int[10];
		int i;
		for (i=0;i<10;i++){
			x[i] = i;
		}
		for (i=0;i<10;i++){
			System.out.print(x[i]);
		}
	}
}