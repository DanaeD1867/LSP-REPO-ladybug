package src.org.howard.edu.lsp.midterm.question2;

public class AreaCalculator{
    //Circle area
    public static double area(double radius){
        try{
            if(radius <= 0.00){throw new IllegalArgumentException();}
            return Math.PI * Math.pow(radius, 2); 
        }catch(IllegalArgumentException exception){
            System.out.println("Error: Dimensions must be a positive value.");
            return -1.00; 
        }
    }

    //Rectangle area
    public static double area(double width, double height){
        try{
            if(width <= 0.0 || height <= 0.00){throw new IllegalArgumentException();}
            return width * height;
        }catch(IllegalArgumentException exception){
            System.out.println("Error: Dimensions must be a positive value."); 
            return -1.00; 
        }
    }

    //Triangle area
    public static double area(int base, int height){
        try{
            if(base <= 0 || height <= 0){throw new IllegalArgumentException();}
            return 0.5 * base * height;
        }catch(IllegalArgumentException exception){
            System.out.println("Error: Dimensions must be a positive value.");
            return -1.00;

        }   
    }

    //Square area
    public static double area(int side){
        try{
            if(side <= 0){throw new IllegalArgumentException();}
            return Math.pow(side, 2);
        } catch(IllegalArgumentException excpetion){
            System.out.println("Error: Dimensions must be a positive value."); 
            return -1.00;
        }
        
    }
}
