import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter line: ");
        String line = scanner.nextLine();

        String[] lineArr = line.split(" ");

        for (String str : lineArr) {
            System.out.println(str);
        }
    }
}