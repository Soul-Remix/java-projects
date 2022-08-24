import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        ArrayList<String> namesList = new ArrayList<>();

        System.out.print("Name of the file: ");
        String fileName = line.nextLine();

        try {
            Scanner scanner = new Scanner(Paths.get(fileName));

            while (scanner.hasNextLine()) {
                namesList.add(scanner.nextLine());
            }
        } catch (Exception ex) {
            System.out.println("Reading the file " + fileName + " failed.");
            return;
        }

        System.out.print("Search For: ");
        String name = line.nextLine();

        if (namesList.contains(name)) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found!");
        }
    }
}