import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.valueOf(scanner.nextLine());

        System.out.println("total: " + square(number));
    }

    public static int square(int n) {
        return n*n;
    }
}