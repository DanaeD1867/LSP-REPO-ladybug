package src.org.howard.edu.lsp.midterm.question2;


public class Main {

    /** Even though it is possible to use overloading, it's always best to use methods with different names. 
     * It significantly increases readability and improves debuginning as it is significantlly clearer where an error is coming from. 
     */
   public static void main(String[] args) {

        double circleArea = AreaCalculator.area(3.0);
        double rectangleArea = AreaCalculator.area(5.0, 2.0); 
        double triangleArea = AreaCalculator.area(10, 6);
        double squareArea = AreaCalculator.area(4); 
        System.out.println("Circle radius 3.0 -> area =  " + String.valueOf(circleArea)); 
        System.out.println("Rectangle 5.0 * 2.0 -> area = " + String.valueOf(rectangleArea));
        System.out.println("Triangle base 10, height 6 -> area = " + String.valueOf(triangleArea));
        System.out.println("Square side 4 -> area = " + String.valueOf(squareArea));

        double illegalArg = AreaCalculator.area(-1); 

    }
    
}
