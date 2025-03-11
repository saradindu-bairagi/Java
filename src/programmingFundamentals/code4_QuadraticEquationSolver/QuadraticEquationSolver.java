package code4_QuadraticEquationSolver;

import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void solveQuadraticEquation(int a, int b, int c) {
        double discriminant = Math.pow(b, 2) - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The roots are " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2.0 * a);
            System.out.println("The root is " + root);
        } else {
            System.out.println("The equation has no real roots");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input values
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();

        // Solve the quadratic equation
        solveQuadraticEquation(a, b, c);

        scanner.close();
    }
}
