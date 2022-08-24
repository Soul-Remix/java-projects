import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        int count = 0;

        System.out.print("Name of the file: ");
        String fileName = line.nextLine();

        System.out.print("Lower bound: ");
        int lower = Integer.parseInt(line.nextLine());

        System.out.print("Upper bound: ");
        int upper = Integer.parseInt(line.nextLine());

        try {
            Scanner scanner = new Scanner(Paths.get(fileName));

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();

                if (row.isEmpty()) {
                    continue;
                }

                int num = Integer.parseInt(row);

                if (num >= lower && num <= upper) {
                    count++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Reading the file " + fileName + " failed.");
            return;
        }

        System.out.println("Numbers: " + count);
    }
}