import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int negativeCount = 0;

        while (true) {
            System.out.println("Enter a number");
            int number = Integer.parseInt(scanner.nextLine());

            if (number == 0) {
                break;
            } else if (number < 0) {
                negativeCount += 1;
            }
        }
        System.out.println("Number of negative numbers: " + negativeCount);
    }
}