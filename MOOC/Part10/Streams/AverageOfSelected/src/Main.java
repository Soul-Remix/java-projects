import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            list.add(input);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String avgType = scanner.nextLine();

        double avg = 0;
        if (avgType.equals("n")) {
            avg = list.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(n -> n < 0)
                    .average()
                    .getAsDouble();
        } else {
            avg = list.stream()
                    .mapToInt(Integer::valueOf)
                    .filter(n -> n > 0)
                    .average()
                    .getAsDouble();
        }
        System.out.println("average of the numbers: " + avg);
    }
}