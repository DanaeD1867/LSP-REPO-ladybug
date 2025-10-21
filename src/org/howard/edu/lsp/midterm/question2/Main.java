package src.org.howard.edu.lsp.midterm.question2;


public class Main {

    /**It's always better to give class names clear and distinct names. Software engineering is a team sport and it's importnat
     * that any can come in at any point in the development process and be able to quickly understand your code. So although 
     * overloading may work, it should be avoided when possible.
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
