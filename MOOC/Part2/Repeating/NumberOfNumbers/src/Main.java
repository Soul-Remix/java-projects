import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersCount = 0;

        while (true) {
            System.out.println("Enter a number (0 exits)");

            int number = Integer.parseInt(scanner.nextLine());

            if (number == 0) {
                break;
            }

            numbersCount += 1;
        }
        System.out.println("Number of numbers: " + numbersCount);
    }
}