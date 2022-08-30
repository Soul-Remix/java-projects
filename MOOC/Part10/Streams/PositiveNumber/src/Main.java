import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Input numbers, type \"end\" to stop.");
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }
            list.add(Integer.parseInt(input));
        }

        System.out.println("Positive numbers: " + positive(list));
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(n -> n > 0).collect(Collectors.toList());
    }
}