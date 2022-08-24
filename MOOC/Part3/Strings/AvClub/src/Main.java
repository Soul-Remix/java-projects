import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                break;
            }
            String[] lineArr = line.split(" ");

            for (String str : lineArr) {
                if (str.contains("av")) {
                    System.out.println(str);
                }
            }
        }
    }
}