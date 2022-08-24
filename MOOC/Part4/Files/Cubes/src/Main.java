import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            int num = Integer.parseInt(input);

            System.out.println(cube(num));
        }
    }

    public static int cube(int num) {
        if (num <= 0) {
            return num;
        }
        return num * num * num;
    }
}