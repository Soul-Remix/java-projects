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
        System.out.print("Search for: ");
        String searchFor = scanner.nextLine();

        if (array.contains(searchFor)) {
            System.out.println(searchFor + " was found!");
        } else {
            System.out.println(searchFor + " was not found!");
        }
    }
}