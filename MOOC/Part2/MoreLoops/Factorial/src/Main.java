import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a number");
        int number = Integer.parseInt(scanner.nextLine());
        int factorialNum = factorial(number);

        System.out.println("Factorial: " + factorialNum);
    }

    public static int factorial(int n) {
        int total = 1;

        for (int i = 1; i <= n; i++) {
            total *= i;
        }
        return total;
    }
}