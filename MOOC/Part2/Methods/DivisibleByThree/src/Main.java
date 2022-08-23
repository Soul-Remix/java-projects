import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number:");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.println("Second number:");
        int second = Integer.parseInt(scanner.nextLine());

        divisibleByThree(first,second);
    }

    public static void divisibleByThree(int n1, int n2) {
        for (int i = n1; i <= n2; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}