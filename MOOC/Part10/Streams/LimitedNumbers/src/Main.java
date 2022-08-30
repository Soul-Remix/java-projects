import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input < 0) {
                break;
            }
            list.add(input);
        }
        list.stream()
                .filter(n -> n >= 1 && n <= 5)
                .forEach(System.out::println);
    }
}