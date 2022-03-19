import classes.*;

public class Zelda {
    public static void main(String[] args) {
        InOut in = new InOut();
        Shapes s = new Shapes(25, 49);
        Triangle t = new Triangle(25, 49);
    
    
        InOut.ClearScreen();
        //s.MakeZelda();
        t.MakeATriangle(25, 49, 25, 3);
        s.PrintTheShape(25, 49);
    }
}	
