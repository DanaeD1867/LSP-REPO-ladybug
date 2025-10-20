package src.org.howard.edu.lsp.midterm.question2;

public class AreaCalculator{
    //Circle area
    public static double area(double radius){
        if(radius > 0.0){
            return Math.PI * Math.pow(radius, 2); 
        }else{
            throw new IllegalArgumentException("Radius must be a positive value.");
        }
    }

    //Rectangle area
    public static double area(double width, double height){
        if(width > 0.0 && height > 0.0){
            return width * height;
        }else{
            throw new IllegalArgumentException("Square dimensions must be a positive value.");
        }
    }

    //Triangle area
    public static double area(int base, int height){
        if(base > 0 && height > 0){
            return 0.5 * base * height;
         }else{
            throw new IllegalArgumentException("Square dimensions must be a positive value.");
        }
        
    }

    //Square area
    public static double area(int side){
        if(side > 0){
            return Math.pow(side, 2);
         }else{
            throw new IllegalArgumentException("Square dimensions must be a positive value.");
        }
        
    }
}
