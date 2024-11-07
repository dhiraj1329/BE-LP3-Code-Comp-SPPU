import java.util.Scanner;

public class Fibonacci {

    // Iterative method to print Fibonacci sequence up to 'n' terms
    public static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence (Iterative): ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    // Recursive method to calculate Fibonacci number at position 'n'
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Method to print Fibonacci sequence using recursion up to 'n' terms
    public static void fibonacciRecursiveSequence(int n) {
        System.out.print("Fibonacci Sequence (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms to print in Fibonacci sequence: ");
        int n = scanner.nextInt();

        // Print Fibonacci sequence iteratively
        fibonacciIterative(n);

        // Print Fibonacci sequence recursively
        fibonacciRecursiveSequence(n);
    }
}
