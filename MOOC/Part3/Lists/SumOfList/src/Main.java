import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();

        while (true) {
            int input = Integer.parseInt(scanner.nextLine());

            if (input == 0) {
                break;
            }
            array.add(input);
        }

        int sum = 0;
        for (Integer num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }
}