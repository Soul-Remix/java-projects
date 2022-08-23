import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> array = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                break;
            }
            array.add(input);
        }
        System.out.println(array.get(0));
        System.out.println(array.get(array.size() - 1));
    }
}