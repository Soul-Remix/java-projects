import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Number");
        int n1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Second number");
        int n2 = Integer.parseInt(scanner.nextLine());

        int smallestNum = smallest(n1,n2);
        System.out.println("Smallest num is: " + smallestNum);
    }
    public static int smallest(int n1,int n2) {
        return Math.min(n1,n2);
    }
}