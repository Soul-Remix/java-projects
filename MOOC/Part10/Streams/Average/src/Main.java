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
        double avg = list.stream().mapToInt(Integer::valueOf).average().getAsDouble();
        System.out.println("average of the numbers: " + avg);
    }
}