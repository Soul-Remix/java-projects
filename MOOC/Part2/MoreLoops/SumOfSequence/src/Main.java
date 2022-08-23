import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Last number");
        int number = Integer.parseInt(scanner.nextLine());
        int total = 0;

        for (int i = 1; i <= number; i++) {
            total += i;
        }

        System.out.println("Total: " + total);
    }
}