import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.valueOf(scanner.nextLine());
        int second = Integer.valueOf(scanner.nextLine());

        if (first > second) {
            System.out.println(first + "Is greater than " + second);
        } else if (second > first) {
            System.out.println(second + " is grater than " + first);
        } else {
            System.out.println(second + " and " + first + " are equal");
        }

        System.out.println("Hello world!");
    }
}