import java.util.Scanner;
public class solveSeDegEquation {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        System.out.println("Input a = ");
        double a = input.nextDouble();

        System.out.println("Input b = ");
        double b = input.nextDouble();

        System.out.println("Input c = ");
        double c = input.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if( a == 0){
            if(b == 0 && c == 0){
                System.out.println("The equation has infinite solutions.");
            } else if(b == 0 && c != 0){
                System.out.println("The equation has no solution.");
            } else {
                double x = -b / a;
                System.out.println("The result is " + x);
            }
        }
        if (discriminant > 0) {
            //real
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The equation has two real result:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("The equation has one result: ");
            System.out.println("x = " + x);
        } else {
            //complex
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-discriminant) / (2 * a);
            System.out.println("The equation has two complex result:");
            System.out.println("x1 = " + real + " + " + imaginary + "i");
            System.out.println("x2 = " + real + " - " + imaginary + "i");
        }
    }
}
