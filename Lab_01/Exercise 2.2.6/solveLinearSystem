import java.util.Scanner;
public class solveLinearSystem {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();
            
        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();
            
        System.out.print("Enter constant b1: ");
        double b1 = scanner.nextDouble();

        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();
        
        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();
        
        System.out.print("Enter constant b2: ");
        double b2 = scanner.nextDouble();
        
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if ((D2) == 0 && (D1) == 0) {
                System.out.println("The system has infinite solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        } else {
            double x = D1 / D;
            double y = D2 / D;
            
            System.out.println("The solution is: ");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

    }
}
