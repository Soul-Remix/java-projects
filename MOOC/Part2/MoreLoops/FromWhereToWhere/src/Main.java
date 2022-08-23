import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("From where:");
        int where = Integer.parseInt(scanner.nextLine());

        System.out.println("To where");
        int to = Integer.parseInt(scanner.nextLine());

        if (where > to) {
            for (int i = where; i >= to; i--) {
                System.out.println(i);
            }
        } else {
            for (int i = where; i <= to; i++) {
                System.out.println(i);
            }
        }
    }
}