import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        System.out.println("Which file should have its contents printed?");
        String file = line.nextLine();

        try {
            Scanner scanner = new Scanner(Paths.get(file));

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                System.out.println(row);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}